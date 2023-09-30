package jhcode.blog.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(value = "SELECT b FROM Board b JOIN FETCH b.member JOIN FETCH b.comments JOIN FETCH b.files WHERE b.id = :boardID")
    Optional<Board> findByIdWithMemberAndCommentsAndFiles(Long boardID);

    @Query(value = "SELECT b FROM Board b JOIN FETCH b.member JOIN FETCH b.comments")
    Page<Board> findAllWithMemberAndComments(Pageable pageable);

    // 제목 검색
    @Query(value = "SELECT b FROM Board b JOIN FETCH b.member JOIN FETCH b.comments WHERE b.title LIKE %:title%")
    Page<Board> findByTitleContaining(String title, Pageable pageable);

    // 내용 검색
    @Query(value = "SELECT b FROM Board b JOIN FETCH b.member JOIN FETCH b.comments WHERE b.content LIKE %:content%")
    Page<Board> findByContentContaining(String content, Pageable pageable);

    // 작성자 검색
    @Query(value = "SELECT b FROM Board b JOIN FETCH b.member JOIN FETCH b.comments WHERE b.member.username LIKE %:username%")
    Page<Board> findByUsernameContaining(String username, Pageable pageable);
}
