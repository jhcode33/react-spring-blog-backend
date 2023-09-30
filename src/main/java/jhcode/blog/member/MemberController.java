package jhcode.blog.member;

import jhcode.blog.member.dto.request.MemberLoginDto;
import jhcode.blog.member.dto.request.MemberRegisterDto;
import jhcode.blog.member.dto.request.MemberUpdateDto;
import jhcode.blog.member.dto.response.MemberResponseDto;
import jhcode.blog.member.dto.response.MemberTokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<MemberResponseDto> register(@RequestBody MemberRegisterDto memberRegisterDTO) {
        MemberResponseDto successMember = memberService.register(memberRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(successMember);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberTokenDto> login(@RequestBody MemberLoginDto memberLoginDTO) {
        MemberTokenDto loginDTO = memberService.login(memberLoginDTO);
        return ResponseEntity.status(HttpStatus.OK).header(loginDTO.getToken()).body(loginDTO);
    }

    @PostMapping("/check")
    public ResponseEntity<MemberResponseDto> check(
            @AuthenticationPrincipal Member member,
            @RequestParam("password") String password) {
        MemberResponseDto memberInfo = memberService.check(member, password);
        return ResponseEntity.status(HttpStatus.OK).body(memberInfo);
    }

    @PutMapping("/update")
    public ResponseEntity<MemberResponseDto> update(@RequestBody MemberUpdateDto memberUpdateDTO) {
        MemberResponseDto memberUpdate = memberService.update(memberUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(memberUpdate);
    }
}
