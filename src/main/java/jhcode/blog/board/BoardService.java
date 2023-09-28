package jhcode.blog.board;

import jakarta.transaction.Transactional;
import jhcode.blog.board.dto.BoardDTO;
import jhcode.blog.common.exception.ResourceNotFoundException;
import jhcode.blog.member.Member;
import jhcode.blog.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    // 페이징 리스트
    public Page<Board> getAllBoards(Pageable pageable) {
        Page<Board> boards = boardRepository.findAllWithMember(pageable);
        return boards;
    }

    // 게시글 등록
    public BoardDTO write(BoardDTO boardDTO, Member member) {
        Board board = boardDTO.toEntity();
        board.setMappingMember(member); //연관관계 설정
        Board saveBoard = boardRepository.save(board);
        return saveBoard.toBoardDTO();
    }

    // 게시글 상세보기
    // comment, file 추가되면 JPQL로 변경해야함 -> 전체 데이터를 한방에 가져올 수 있도록
    public BoardDTO detail(Long boardId) {
       Board findBoard = boardRepository.findByIdWithMember(boardId).orElseThrow(
               () -> new ResourceNotFoundException("Board", "Board Id", String.valueOf(boardId))
       );
       // 조회수 증가
       findBoard.upViewCount();
       return findBoard.toBoardDTO();
    }

    // 게시글 수정
    public BoardDTO update(BoardDTO boardDTO) {
        Board updateBoard = boardRepository.findByIdWithMember(boardDTO.getBoardId()).orElseThrow(
                () -> new ResourceNotFoundException("Board", "Board Id", String.valueOf(boardDTO.getBoardId()))
        );
        updateBoard.update(boardDTO.getTitle(), boardDTO.getContent(), boardDTO.getCategory());
        return updateBoard.toBoardDTO();
    }
}
