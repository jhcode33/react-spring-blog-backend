package jhcode.blog.member;

import jakarta.transaction.Transactional;
import jhcode.blog.common.exception.ResourceNotFoundException;
import jhcode.blog.member.dto.MemberLoginDTO;
import jhcode.blog.member.dto.MemberRegisterDTO;
import jhcode.blog.member.dto.MemberUpdateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtTokenUtil jwtTokenUtil;

    public MemberRegisterDTO register(MemberRegisterDTO memberRegisterDTO) {
        if (checkPassword(memberRegisterDTO.getPassword(), memberRegisterDTO.getPasswordConfirmation())) {
            Member saveMember = memberRepository.save(memberRegisterDTO.toMemberEntity());
            return saveMember.toRegisterDTO();
        } else {
            log.info("회원 가입 실패");
            return null;
        }
    }

    private Boolean checkPassword(String password, String passwordConfirmation) {
        if (password.equals(passwordConfirmation)) {
            log.info("패스워드 일치");
            return true;
        } else {
            log.info("패스워드 불일치");
            return false;
        }
    }

    public MemberUpdateDTO update(MemberUpdateDTO memberUpdateDTO) {
        if (checkPassword(memberUpdateDTO.getPassword(), memberUpdateDTO.getPasswordConfirmation())) {
            Member updateMember = memberRepository.findByEmail(memberUpdateDTO.getEmail()).orElseThrow(
                    () -> new ResourceNotFoundException("Member", "Member Email", memberUpdateDTO.getEmail())
            );
            updateMember.update(memberUpdateDTO.getPassword(), memberUpdateDTO.getUsername());
            return updateMember.toUpdateDTO();
        } else {
            log.info("비밀번호 불일치");
            return null;
        }
    }

    public MemberLoginDTO login(MemberLoginDTO memberLoginDTO) {
        if (checkPassword(memberLoginDTO.getPassword(), memberLoginDTO.getPasswordConfirmation())) {

        }
    }
}
