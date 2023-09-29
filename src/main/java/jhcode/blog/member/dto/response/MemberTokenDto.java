package jhcode.blog.member.dto.response;

import jhcode.blog.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 사용자 정보 반환 + token Dto
 */

@Getter
@Setter
@NoArgsConstructor
public class MemberTokenDto {
    private String email;
    private String password;
    private String username;
    private String token;

    @Builder
    public MemberTokenDto(String email, String password, String username, String token) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.token = token;
    }

    // Entity -> DTO
    public static MemberTokenDto fromEntity(Member member, String token) {
        return MemberTokenDto.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .username(member.getUsername())
                .token(token)
                .build();
    }
}
