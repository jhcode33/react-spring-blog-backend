package jhcode.blog.dto.response.member;

import jhcode.blog.entity.Member;
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
    // 사용자 DB 인덱스 값을 굳이 사용자에게 노출시킬 필요는 없다고 생각
    private String email;
    private String username;

    @Builder
    public MemberResponseDto(String email, String username) {
        this.email = email;
        this.username = username;
    }

    // Entity -> DTO
    public static MemberResponseDto fromEntity(Member member) {
        return MemberResponseDto.builder()
                .email(member.getEmail())
                .username(member.getUsername())
                .build();
    }
}
