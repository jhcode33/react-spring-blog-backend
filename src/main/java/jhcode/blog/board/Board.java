package jhcode.blog.board;

import jakarta.persistence.*;
import jhcode.blog.common.BaseTimeEntity;
import jhcode.blog.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(name = "VIEW_COUNT")
    private Integer viewCount;

    private String category;

    @ManyToOne
    @JoinColumn(name = "memberId")
    public Member member;

    @Builder
    public Board(Long id, String title, String content, Integer viewCount, String category, Member member) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.category = category;
        this.member = member;
    }
}
