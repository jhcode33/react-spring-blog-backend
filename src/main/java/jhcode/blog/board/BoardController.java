package jhcode.blog.board;

import jhcode.blog.board.dto.BoardDTO;
import jhcode.blog.board.dto.BoardListDTO;
import jhcode.blog.member.Member;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public ResponseEntity<Page<Board>> boardList(
            @PageableDefault(size = 5, sort = "boardId", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Board> listDTO = boardService.getAllBoards(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    @PostMapping("/board/write")
    public ResponseEntity<BoardDTO> write(@RequestBody BoardDTO boardDTO,
    @AuthenticationPrincipal Member member) {
        BoardDTO saveBoardDTO = boardService.write(boardDTO, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveBoardDTO);
    }
}
