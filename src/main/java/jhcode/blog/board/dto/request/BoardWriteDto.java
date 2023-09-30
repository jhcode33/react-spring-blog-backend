package jhcode.blog.board.dto.request;

import jhcode.blog.board.Board;
import jhcode.blog.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * -Request-
 * 게시글 등록 정보 요청, 작성자는 Authentication 받음
 */

@Getter
@Setter
@NoArgsConstructor
public class BoardWriteDto {

    private String title;
    private String content;
    private String category;

    public BoardWriteDto(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    @Builder
    public static Board ofEntity(BoardWriteDto dto) {
        return Board.builder()
                .title(dto.title)
                .content(dto.content)
                .category(dto.category)
                .build();
    }
}
