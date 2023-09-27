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
public class MemberUpdateDTO {

    private Long memberId;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String username;

    @Builder
    public MemberUpdateDTO(Long memberId, String email, String password, String passwordConfirmation, String username) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.username = username;
    }

    public Member toMemberEntity() {
        return Member.builder()
                .email(this.email)
                .password(this.password)
                .username(this.username)
                .roles(Role.USER)
                .build();
    }
}
