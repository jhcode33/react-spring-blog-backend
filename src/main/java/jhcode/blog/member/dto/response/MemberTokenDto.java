package jhcode.blog.member.dto.response;

import jhcode.blog.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * -Response-
 * 사용자 정보 반환 + token Dto
 */

@Getter
@Setter
@NoArgsConstructor
public class MemberTokenDto {
    private String email;
    private String password;
    private String token;

    @Builder
    public MemberTokenDto(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }

    // Entity -> DTO
    public static MemberTokenDto fromEntity(UserDetails member, String token) {
        return MemberTokenDto.builder()
                .email(member.getUsername())
                .password(member.getPassword())
                .token(token)
                .build();
    }
}
