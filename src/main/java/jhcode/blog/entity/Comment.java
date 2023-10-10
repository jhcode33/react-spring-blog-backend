package jhcode.blog.entity;

import jakarta.persistence.*;
import jhcode.blog.common.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "COMMENT_ID")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    public Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    public Board board;

    @Builder
    public Comment(Long id, String content, Member member, Board board) {
        this.id = id;
        this.content = content;
        this.member = member;
        this.board = board;
    }

    // Board와의 다대일(N:1) 관계를 설정하는 메소드
    public void setBoard(Board board) {
        this.board = board;
        board.getComments().add(this); // Board 엔티티에도 Comment를 추가합니다.
    }

    // Member와의 다대일(N:1) 관계를 설정하는 메소드
    public void setMember(Member member) {
        this.member = member;
        member.getComments().add(this); // Member 엔티티에도 Comment를 추가합니다.
    }

    // update
    public void update(String content) {
        this.content = content;
    }
}
