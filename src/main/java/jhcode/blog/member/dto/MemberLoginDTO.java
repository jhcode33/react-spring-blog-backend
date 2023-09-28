package jhcode.blog.member.dto;

import jhcode.blog.common.Role;
import jhcode.blog.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberLoginDTO {
    private Long memberId;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String username;
    private String role;
    private String token;

    @Builder
    public MemberLoginDTO(Long memberId, String email, String password, String passwordConfirmation, String username, String role, String token) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.username = username;
        this.role = role;
        this.token = token;
    }
}
