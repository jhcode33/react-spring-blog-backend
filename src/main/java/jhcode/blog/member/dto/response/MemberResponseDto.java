package jhcode.blog.member.dto.response;

import jhcode.blog.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * -Response-
 * 사용자 정보 반환 Dto
 */

@Getter
@Setter
@NoArgsConstructor
public class MemberResponseDto {
    // DB 인덱스 값을 굳이 사용자에게 노출시킬 필요는 없다고 생각
    private String email;
    private String password;
    private String username;

    @Builder
    public MemberResponseDto(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    // Entity -> DTO
    public static MemberResponseDto fromEntity(Member member) {
        return MemberResponseDto.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .username(member.getUsername())
                .build();
    }
}
