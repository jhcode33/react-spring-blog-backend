package jhcode.blog.file.dto;

import jhcode.blog.file.FileEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class FileDTO {

    private Long id;
    private String originFileName;
    private String filePath;
    private String fileType;

    @Builder
    public FileDTO(Long id, String originFileName, String filePath, String fileType) {
        this.id = id;
        this.originFileName = originFileName;
        this.filePath = filePath;
        this.fileType = fileType;
    }

    public FileEntity toEntity() {
        return FileEntity.builder()
                .id(this.id)
                .originFileName(this.originFileName)
                .filePath(this.filePath)
                .build();
    }
}
