package jhcode.blog.member;

import jhcode.blog.member.dto.MemberLoginDTO;
import jhcode.blog.member.dto.MemberRegisterDTO;
import jhcode.blog.member.dto.MemberUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<MemberRegisterDTO> register(@RequestBody MemberRegisterDTO memberRegisterDTO) {
        MemberRegisterDTO successMember = memberService.register(memberRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(successMember);
    }

    @PutMapping("/update")
    public ResponseEntity<MemberUpdateDTO> update(@RequestBody MemberUpdateDTO memberUpdateDTO) {
        MemberUpdateDTO memberUpdate = memberService.update(memberUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(memberUpdate);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberLoginDTO> login(@RequestBody MemberLoginDTO memberLoginDTO) {
        MemberLoginDTO loginDTO = memberService.login(memberLoginDTO);
        return ResponseEntity.status(HttpStatus.OK).header(loginDTO.getToken()).body(loginDTO);
    }
}
