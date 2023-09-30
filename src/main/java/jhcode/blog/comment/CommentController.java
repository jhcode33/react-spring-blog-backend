package jhcode.blog.comment;

import jhcode.blog.comment.dto.CommentInfoDTO;
import jhcode.blog.comment.dto.request.CommentDto;
import jhcode.blog.comment.dto.response.ResCommentDto;
import jhcode.blog.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board/{boardId}/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/write")
    public ResponseEntity<ResCommentDto> write(
            @AuthenticationPrincipal Member member,
            @PathVariable Long boardId,
            @RequestBody CommentDto commentWriteDto) {
        ResCommentDto saveCommentDTO = commentService.write(boardId, member, commentWriteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCommentDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<CommentInfoDTO> update(
            @AuthenticationPrincipal Member member,
            @RequestBody CommentDto commentDTO) {
        CommentInfoDTO updateCommentDTO = commentService.update(member, commentDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateCommentDTO);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Long> delete(
            @AuthenticationPrincipal Member member,
            @PathVariable Long commentId) {
        commentService.delete(member, commentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
