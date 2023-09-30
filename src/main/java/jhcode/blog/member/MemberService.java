package jhcode.blog.member;

import jakarta.transaction.Transactional;
import jhcode.blog.common.exception.MemberException;
import jhcode.blog.common.exception.ResourceNotFoundException;
import jhcode.blog.member.dto.request.MemberLoginDto;
import jhcode.blog.member.dto.request.MemberRegisterDto;
import jhcode.blog.member.dto.request.MemberUpdateDto;
import jhcode.blog.member.dto.response.MemberResponseDto;
import jhcode.blog.member.dto.response.MemberTokenDto;
import jhcode.blog.security.jwt.CustomUserDetailsService;
import jhcode.blog.security.jwt.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {

    private final PasswordEncoder encoder;
    private final MemberRepository memberRepository;
    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    public MemberResponseDto register(MemberRegisterDto registerDto) {
        // 이메일 확인
        isExistUserEmail(registerDto.getEmail());

        // 패스워드 일치 확인
        checkPassword(registerDto.getPassword(), registerDto.getPasswordCheck());

        // 패스워드 암호화
        String encodePwd = encoder.encode(registerDto.getPassword());
        registerDto.setPassword(encodePwd);

        Member saveMember = memberRepository.save(
                MemberRegisterDto.ofEntity(registerDto));

        return MemberResponseDto.fromEntity(saveMember);
    }


    public MemberTokenDto login(MemberLoginDto loginDTO) {
        Member member = (Member) userDetailsService.loadUserByUsername(loginDTO.getEmail());
        checkEncodePassword(loginDTO.getPassword(), member.getPassword());
        String token = jwtTokenUtil.generateToken(member);
        return MemberTokenDto.fromEntity(member, token);
    }

    public MemberResponseDto check(Member member, String password) {
        Member checkMember = (Member) userDetailsService.loadUserByUsername(member.getEmail());
        checkEncodePassword(checkMember.getPassword(), member.getPassword());
        return MemberResponseDto.fromEntity(checkMember);
    }

    public MemberResponseDto update(MemberUpdateDto updateDto) {
        checkPassword(updateDto.getPassword(), updateDto.getPasswordCheck());
        String encodePwd = encoder.encode(updateDto.getPassword());

        Member updateMember = findByEmail(updateDto.getEmail());
        updateMember.update(encodePwd, updateDto.getUsername());
        return MemberResponseDto.fromEntity(updateMember);
    }

    private void isExistUserEmail(String email) {
        if (memberRepository.findByEmail(email).isPresent()) {
            throw new MemberException("이미 사용 중인 이메일입니다.", HttpStatus.BAD_REQUEST);
        }
    }

    private void checkPassword(String password, String passwordCheck) {
        if (!password.equals(passwordCheck)) {
            throw new MemberException("패스워드 불일치", HttpStatus.BAD_REQUEST);
        }
    }

    private void checkEncodePassword(String rawPassword, String encodedPassword) {
        if (!encoder.matches(rawPassword, encodedPassword)) {
            throw new MemberException("패스워드 불일치", HttpStatus.BAD_REQUEST);
        }
    }

    private Member findByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Member", "Member Email", email)
        );
    }
}
