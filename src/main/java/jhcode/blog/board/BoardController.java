package jhcode.blog.board;

import jhcode.blog.board.dto.BoardDTO;
import jhcode.blog.board.dto.SearchData;
import jhcode.blog.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 페이징 목록
    @GetMapping("/list")
    public ResponseEntity<Page<Board>> boardList(
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Board> listDTO = boardService.getAllBoards(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 페이징 검색
    @GetMapping("/search")
    public ResponseEntity<Page<Board>> search(
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestBody SearchData searchData) {
        Page<Board> searchBoard = boardService.search(searchData, pageable);
        return  ResponseEntity.status(HttpStatus.OK).body(searchBoard);
    }

    @PostMapping("/write")
    public ResponseEntity<BoardDTO> write(@RequestBody BoardDTO boardDTO,
                                          @AuthenticationPrincipal Member member) {
        BoardDTO saveBoardDTO = boardService.write(boardDTO, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveBoardDTO);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDTO> detail(@PathVariable("boardId") Long boardId) {
        BoardDTO findBoardDTO = boardService.detail(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(findBoardDTO);
    }

    // 상세보기 -> 수정
    @PutMapping("/{boardId}/update")
    public ResponseEntity<BoardDTO> update(@RequestBody BoardDTO boardDTO, @PathVariable Long boardId) {
        boardDTO.setBoardId(boardId);
        BoardDTO updateBoardDTO = boardService.update(boardDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateBoardDTO);
    }

    // 상세보기 -> 삭제
    @DeleteMapping("/{boardId}/delete")
    public ResponseEntity<Long> delete(@PathVariable Long boardId) {
        boardService.delete(boardId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
