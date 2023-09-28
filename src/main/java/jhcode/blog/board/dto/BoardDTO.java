package jhcode.blog.board.dto;

import jhcode.blog.board.Board;
import jhcode.blog.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardDTO {

    private Long boardId;
    private String title;
    private String content;
    private Integer viewCount;
    private String category;
    private Member member;

    @Builder
    public BoardDTO(Long boardId, String title, String content, Integer viewCount, String category, Member member) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.category = category;
        this.member = member;
    }

    public Board toEntity() {
        return Board.builder()
                .id(this.boardId)
                .title(this.title)
                .content(this.content)
                .viewCount(this.viewCount)
                .category(this.category)
                .member(this.member)
                .build();
    }
}
