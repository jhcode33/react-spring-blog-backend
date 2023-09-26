package jhcode.blog.member;

import jakarta.persistence.*;
import jhcode.blog.common.BaseTimeEntity;
import jhcode.blog.common.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long memberId;

    // 이메일로 로그인함
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Enumerated(EnumType.STRING)
    private Role roles;


    //== 생성자 ==//
    public Member() {}

    @Builder
    public Member(String email, String password, String username, Role roles) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public void update(String password, String username) {
        this.password = password;
        this.username = username;
    }
}
