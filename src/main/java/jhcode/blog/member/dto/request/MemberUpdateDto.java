package jhcode.blog.member.dto.request;

import jhcode.blog.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * -Request-
 * 회원 정보 변경 요청 dto
 */

@Getter
@Setter
@NoArgsConstructor
public class MemberUpdateDto {
    // ==> 지금은 정보가 별로 없어서 다른 dto와 차별점이 없으나 차후 충분히 늘어날 수 있다고 생각
    private String email;
    private String password;
    private String passwordCheck;
    private String username;

    @Builder
    public MemberUpdateDto(String email, String password, String passwordCheck, String username) {
        this.email = email;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.username = username;
    }
}
