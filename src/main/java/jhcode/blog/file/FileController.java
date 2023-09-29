package jhcode.blog.file;

import jhcode.blog.file.dto.FileDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<FileDTO> upload (
            @PathVariable Long boardId,
            @RequestParam("file") MultipartFile file) throws IOException {
        // IOException을 Runtime으로 처리해야하지 않을까?
        FileDTO saveFile = fileService.upload(boardId, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveFile);

    }
}
