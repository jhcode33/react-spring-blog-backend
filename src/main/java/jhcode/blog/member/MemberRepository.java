package jhcode.blog.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    @Query(value = "SELECT m FROM Member m JOIN FETCH m.comments WHERE m.id = :memberId")
    Optional<Member> findByIdWithComments(Long memberId);
}
