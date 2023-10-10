package jhcode.blog.repository;

import jhcode.blog.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT c FROM Comment c JOIN FETCH c.member JOIN FETCH c.board b WHERE b.id = :boardId")
    Page<Comment> findAllWithMemberAndBoard(Pageable pageable, Long boardId);

    @Query(value = "SELECT c FROM Comment c JOIN FETCH c.member m JOIN FETCH c.board b WHERE c.id = :commentId")
    Optional<Comment> findByIdWithMemberAndBoard(Long commentId);
}
