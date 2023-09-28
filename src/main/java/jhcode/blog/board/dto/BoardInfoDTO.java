package jhcode.blog.board.dto;

import jhcode.blog.member.Member;
import jhcode.blog.member.dto.MemberInfoDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardInfoDTO {

    private Long boardId;
    private String title;
    private String content;
    private int viewCount;
    private String category;
    private MemberInfoDTO member;

    @Builder
    public BoardInfoDTO(Long boardId, String title, String content, int viewCount, String category, MemberInfoDTO member) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.category = category;
        this.member = member;
    }
}
