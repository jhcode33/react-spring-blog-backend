package jhcode.blog.board.dto.response;

import jhcode.blog.board.Board;
import jhcode.blog.comment.dto.CommentDTO;
import jhcode.blog.file.dto.FileDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * -Response-
 * 게시글 상세, 수정 요청에 대한 정보를 반환
 */

@Getter
@Setter
@NoArgsConstructor
public class ResBoardDetailsDto {

    // board info
    private String title;
    private String content;
    private String category;
    private String writerName;
    private String createdDate;
    private String modifiedDate;

    // comments
    private List<CommentDTO> comments;

    // file
    private List<FileDTO> files;

    @Builder
    public ResBoardDetailsDto(String title, String content, String category, String writerName, String createdDate, String modifiedDate, List<CommentDTO> comments, List<FileDTO> files) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.writerName = writerName;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.comments = comments;
        this.files = files;
    }

    public static ResBoardDetailsDto fromEntity(Board board) {
        return ResBoardDetailsDto.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .category(board.getCategory())
                .writerName(board.getMember().getUsername())
                .createdDate(board.getCreateDate().toString())
                .modifiedDate(board.getModifiedDate().toString())
                // comments -> 파일 스트림으로 dto로 변환해야함
                // files -> 파일 스트림으로 dto로 변환해야함
                .build();
    }
}
