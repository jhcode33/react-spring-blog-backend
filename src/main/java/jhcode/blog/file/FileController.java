package jhcode.blog.file;

import jhcode.blog.file.dto.response.ResFileUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/board/{boardId}/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResFileUploadDto> upload (
            @PathVariable Long boardId,
            @RequestParam("file") MultipartFile file) throws IOException {
        // IOException을 Runtime으로 처리해야하지 않을까?
        ResFileUploadDto saveFile = fileService.upload(boardId, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveFile);

    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download (
            @RequestParam("fileId") Long fileId) throws IOException {
        byte[] downloadFile = fileService.download(fileId);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileId=\"" + fileId + "\"")
                .body(new ByteArrayResource(downloadFile));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> delete (
            @RequestParam("fileId") Long fileId) {
        fileService.delete(fileId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
