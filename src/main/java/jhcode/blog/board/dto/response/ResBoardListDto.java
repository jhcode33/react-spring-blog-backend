package jhcode.blog.board.dto.response;

import jhcode.blog.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * -Response-
 * list 요청에 대한 정보를 반환, 양방향 관계로 인해 JSON 직렬화가 반복되는 문제를 해결하기 위한 DTO
 */

@Getter
@Setter
@NoArgsConstructor
public class ResBoardListDto {
    // 작성일, 수정일, 작성자, 댓글 개수만 전체 목록에 대한 데이터로 받으면 됨
    // 상세한 댓글 내용 등은 상세보기에서 처리
    private Long boardId;
    private String title;
    private String content;
    private int viewCount;
    private String category;
    private String createdDate;
    private String modifiedDate;
    private String writerName;
    private int commentCount;

    @Builder
    public ResBoardListDto(Long boardId, String title, String content, int viewCount, String category, String createdDate, String modifiedDate, String writerName, int commentCount) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.category = category;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.writerName = writerName;
        this.commentCount = commentCount;
    }

    // Entity -> DTO
    public static ResBoardListDto fromEntity(Board board) {
        return ResBoardListDto.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .viewCount(board.getViewCount())
                .category(board.getCategory())
                .createdDate(board.getCreateDate().toString())
                .modifiedDate(board.getModifiedDate().toString())
                .writerName(board.getMember().getUsername())
                .commentCount(board.getComments().size())
                .build();
    }
}
