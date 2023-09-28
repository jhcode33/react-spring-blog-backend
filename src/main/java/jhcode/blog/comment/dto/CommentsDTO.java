package jhcode.blog.comment.dto;

import jhcode.blog.board.dto.BoardInfoDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentsDTO {

    private Long id;
    private String content;
    private String createdDate;
    private String modifiedDate;

    private BoardInfoDTO board;

    @Builder
    public CommentsDTO(Long id, String content, BoardInfoDTO board, String createdDate, String modifiedDate) {
        this.id = id;
        this.content = content;
        this.board = board;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
