package jhcode.blog.board;

import jakarta.persistence.*;
import jhcode.blog.board.dto.BoardDTO;
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
    private int viewCount;

    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    public Member member;

    @Builder
    public Board(Long id, String title, String content, int viewCount, String category, Member member) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.category = category;
        this.member = member;
    }

    //== 조회수 증가 ==//
    public void upViewCount() {
        this.viewCount++;
    }

    //== 수정 Dirty Checking ==//
    public void update(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    //== Member & Board 연관관계 편의 메소드 ==//
    public void setMappingMember(Member member) {
        this.member = member;
        //member.getBoards().add(this);
    }

    //== DTO ==//
    public BoardDTO toBoardDTO() {
        return BoardDTO.builder()
                .boardId(this.id)
                .title(this.title)
                .content(this.content)
                .viewCount(this.viewCount)
                .category(this.category)
                .member(this.member)
                .build();
    }
}
