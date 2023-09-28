package jhcode.blog.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberInfoDTO {
    private Long memberId;
    private String email;
    private String password;
    private String username;
    private String role;

    @Builder
    public MemberInfoDTO(Long memberId, String email, String password, String username, String role) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }
}
