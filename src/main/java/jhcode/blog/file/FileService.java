package jhcode.blog.file;

import jakarta.transaction.Transactional;
import jhcode.blog.board.Board;
import jhcode.blog.board.BoardRepository;
import jhcode.blog.common.exception.ResourceNotFoundException;
import jhcode.blog.file.dto.response.ResFileDownloadDto;
import jhcode.blog.file.dto.response.ResFileUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class FileService {

    private final BoardRepository boardRepository;
    private final FileRepository fileRepository;

    @Value("${project.folderPath}")
    private String FOLDER_PATH;

    public ResFileUploadDto upload(Long boardId, MultipartFile multipartFile) throws IOException {
        // 게시글 찾기
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new ResourceNotFoundException("Board", "Board Id", String.valueOf(boardId))
        );

        // get origin file name
        String fileName = multipartFile.getOriginalFilename();

        // random name generation of image while uploading to store in folder
        String randomId = UUID.randomUUID().toString();

        // create save File name : ex) POST_boardID_randomID.확장자
        String filePath =
                "POST_" + board.getId() + "_" + randomId.concat(fileName.substring(fileName.indexOf(".")));

        // File.separator : OS에 따른 구분자
        String fileResourcePath = FOLDER_PATH + File.separator + filePath;

        // create folder if not created
        File f = new File(FOLDER_PATH);
        if (!f.exists()) {
            f.mkdir();
        }

        // file copy in folder
        Files.copy(multipartFile.getInputStream(), Paths.get(fileResourcePath));

        // create File Entity & 연관관게 매핑
        FileEntity saveFile = FileEntity.builder()
                .originFileName(multipartFile.getOriginalFilename())
                .filePath(filePath)
                .fileType(multipartFile.getContentType())
                .build();
        saveFile.setMappingBoard(board);

        // File Entity 저장 및 DTO로 변환 전송
        FileEntity fileEntity =fileRepository.save(saveFile);
        return ResFileUploadDto.fromEntity(fileEntity);
    }

    public ResFileDownloadDto download(Long fileId) throws IOException {
        FileEntity file = fileRepository.findById(fileId).orElseThrow(
                () -> new FileNotFoundException()
        );
        String filePath = FOLDER_PATH + file.getFilePath();
        String contentType = determineContentType(file.getFileType());
        byte[] content = Files.readAllBytes(new File(filePath).toPath());
        return ResFileDownloadDto.fromFileResource(file, contentType, content);
    }

    public void delete(Long fileId) {
        FileEntity file = fileRepository.findById(fileId).orElseThrow(
                () -> new ResourceNotFoundException("File", "File Id", String.valueOf(fileId))
        );

        // local 파일을 삭제
        String filePath = FOLDER_PATH + File.separator + file.getFilePath();
        File physicalFile = new File(filePath);
        if (physicalFile.exists()) {
            physicalFile.delete();
        }
        fileRepository.delete(file);
    }

    private String determineContentType(String contentType) {
        // ContentType에 따라 MediaType 결정
        switch (contentType) {
            case "image/png":
                return MediaType.IMAGE_PNG_VALUE;
            case "image/jpeg":
                return MediaType.IMAGE_JPEG_VALUE;
            case "text/plain":
                return MediaType.TEXT_PLAIN_VALUE;
            default:
                return MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
    }
}
