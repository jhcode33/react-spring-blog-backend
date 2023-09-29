package jhcode.blog.file.dto;

import jhcode.blog.file.File;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileDTO {

    private Long id;
    private String originFileName;
    private String filePath;

    @Builder
    public FileDTO(Long id, String originFileName, String filePath) {
        this.id = id;
        this.originFileName = originFileName;
        this.filePath = filePath;
    }

    public File toEntity() {
        return File.builder()
                .id(this.id)
                .originFileName(this.originFileName)
                .filePath(this.filePath)
                .build();
    }
}
