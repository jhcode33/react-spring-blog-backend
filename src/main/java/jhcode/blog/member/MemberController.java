package jhcode.blog.member;

import jhcode.blog.member.dto.MemberRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/user/register")
    public ResponseEntity<MemberRegisterDTO> register(@RequestBody MemberRegisterDTO memberRegisterDTO) {
        MemberRegisterDTO successMember = memberService.register(memberRegisterDTO);
        return ResponseEntity.ok(successMember);
    }
}
