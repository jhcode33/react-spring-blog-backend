package jhcode.blog.comment.dto;

import jhcode.blog.board.dto.BoardInfoDTO;
import jhcode.blog.member.dto.MemberInfoDTO;
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

    private MemberInfoDTO member;

    @Builder
    public CommentsDTO(Long id, String content, String createdDate, String modifiedDate, MemberInfoDTO member) {
        this.id = id;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.member = member;
    }
}
