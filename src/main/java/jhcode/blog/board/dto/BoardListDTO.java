package jhcode.blog.board.dto;

import jhcode.blog.comment.dto.CommentDTO;
import jhcode.blog.comment.dto.CommentsDTO;
import jhcode.blog.member.dto.MemberInfoDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoardListDTO {

    private Long boardId;
    private String title;
    private String content;
    private int viewCount;
    private String category;
    private MemberInfoDTO member;
    private List<CommentsDTO> comments;

    @Builder
    public BoardListDTO(Long boardId, String title, String content, int viewCount, String category, MemberInfoDTO member, List<CommentsDTO> comments) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.category = category;
        this.member = member;
        this.comments = comments;
    }
}
