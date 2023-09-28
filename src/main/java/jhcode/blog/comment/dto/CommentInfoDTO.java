package jhcode.blog.comment.dto;

import jhcode.blog.board.dto.BoardInfoDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentInfoDTO {

    private Long id;
    private String content;
    private String writerName;
    private String createdDate;
    private String modifiedDate;

    private BoardInfoDTO board;

    @Builder
    public CommentInfoDTO(Long id, String content, BoardInfoDTO board, String writerName, String createdDate, String modifiedDate) {
        this.id = id;
        this.content = content;
        this.board = board;
        this.writerName = writerName;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
