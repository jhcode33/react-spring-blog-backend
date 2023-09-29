package jhcode.blog.file;

import jakarta.persistence.*;
import jhcode.blog.board.Board;
import jhcode.blog.common.BaseTimeEntity;
import jhcode.blog.file.dto.FileDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class File extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "FILE_ID")
    private Long id;

    @Column(name = "ORIGIN_FILE_NAME")
    private String originFileName;

    @Column(name = "FILE_PATH")
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    public Board board;

    @Builder
    public File(Long id, String originFileName, String filePath) {
        this.id = id;
        this.originFileName = originFileName;
        this.filePath = filePath;
    }

    public FileDTO toDTO() {
        return FileDTO.builder()
                .id(this.id)
                .originFileName(this.originFileName)
                .filePath(this.filePath)
                .build();
    }
}
