package jhcode.blog.board.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * -Request-
 * 검색 요청에 대한 정보 DTO, 검색 조건이 늘어날 수 있어 객체로 만듬
 */

@Getter
@Setter
public class SearchData {

    String title;
    String content;
    String writerName;
}
