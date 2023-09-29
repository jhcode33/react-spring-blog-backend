package jhcode.blog.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

    @Query(value = "SELECT f FROM FileEntity f JOIN FETCH f.board WHERE f.originFileName = :fileName")
    Optional<FileEntity> findByOriginFileName(String fileName);
}
