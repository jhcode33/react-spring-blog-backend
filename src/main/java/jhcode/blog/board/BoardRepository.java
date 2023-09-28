package jhcode.blog.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(value = "SELECT b FROM Board b JOIN FETCH b.member")
    Page<Board> findAllWithMember(Pageable pageable);

    @Query(value = "SELECT b FROM Board b JOIN FETCH b.member WHERE b.id = :boardID")
    Optional<Board> findByIdWithMember(Long boardID);
}
