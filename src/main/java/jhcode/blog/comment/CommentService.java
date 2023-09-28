package jhcode.blog.comment;

import jhcode.blog.board.Board;
import jhcode.blog.board.BoardRepository;
import jhcode.blog.comment.dto.CommentDTO;
import jhcode.blog.comment.dto.CommentInfoDTO;
import jhcode.blog.common.exception.ResourceNotFoundException;
import jhcode.blog.member.Member;
import jhcode.blog.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public CommentInfoDTO write(Long boardId, Member member, CommentDTO commentDTO) {
        // board 정보 검색
        Board board = boardRepository.findByIdWithMember(boardId).orElseThrow(
                () -> new ResourceNotFoundException("Board", "Board id", String.valueOf(boardId))
        );
        // member(댓글 작성자) 정보 검색
        Member commentWriter = memberRepository.findById(member.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Member", "Member id", String.valueOf(member.getId()))
        );
        Comment comment = commentDTO.toEntity();
        comment.setBoard(board);
        comment.setMember(commentWriter);
        return commentRepository.save(comment).toCommentInfoDTO(member.getUsername());
    }

    public CommentInfoDTO update(Member member, CommentDTO commentDTO) {
        Comment comment = commentRepository.findByIdWithMemberAndBoard(commentDTO.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "Comment Id", String.valueOf(commentDTO.getId()))
        );
        comment.update(commentDTO.getContent());
        return comment.toCommentInfoDTO(member.getUsername());
    }

    public void delete(Member member, Long commentId) {
        Comment comment = commentRepository.findByIdWithMemberAndBoard(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "Comment Id", String.valueOf(commentId))
        );
        comment.delete(); // 연관관계 삭제
        commentRepository.deleteById(commentId);
    }
}
