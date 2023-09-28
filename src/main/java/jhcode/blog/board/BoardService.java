package jhcode.blog.board;

import jakarta.transaction.Transactional;
import jhcode.blog.board.dto.BoardDTO;
import jhcode.blog.board.dto.BoardListDTO;
import jhcode.blog.common.exception.ResourceNotFoundException;
import jhcode.blog.member.Member;
import jhcode.blog.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        board.setMappingMember(member);
        Board saveBoard = boardRepository.save(board);
        return saveBoard.toBoardDTO();
    }
}
