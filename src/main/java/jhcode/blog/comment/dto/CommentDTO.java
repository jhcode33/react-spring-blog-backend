package jhcode.blog.comment.dto;

import jhcode.blog.board.Board;
import jhcode.blog.board.dto.BoardInfoDTO;
import jhcode.blog.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

    private Long id;
    private String content;
    private String createdDate;
    private String modifiedDate;

    private Board board;


    @Builder
    public CommentDTO(Long id, String content, Board board, String createdDate, String modifiedDate) {
        this.id = id;
        this.content = content;
        this.board = board;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Comment toEntity() {
        return Comment.builder()
                .content(this.content)
                .build();
    }
}
