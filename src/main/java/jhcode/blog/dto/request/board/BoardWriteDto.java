package jhcode.blog.dto.request.board;

import jhcode.blog.entity.Board;
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

    public BoardWriteDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Builder
    public static Board ofEntity(BoardWriteDto dto) {
        return Board.builder()
                .title(dto.title)
                .content(dto.content)
                .build();
    }
}
