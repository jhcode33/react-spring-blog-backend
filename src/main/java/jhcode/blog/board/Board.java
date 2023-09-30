package jhcode.blog.board;

import jakarta.persistence.*;
import jhcode.blog.board.dto.request.BoardWriteDto;
import jhcode.blog.board.dto.BoardInfoDTO;
import jhcode.blog.board.dto.response.ResBoardListDto;
import jhcode.blog.comment.Comment;
import jhcode.blog.common.BaseTimeEntity;
import jhcode.blog.file.FileEntity;
import jhcode.blog.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
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
    @JoinColumn(name = "MEMBER_ID")
    public Member member;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    public List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    public List<FileEntity> files = new ArrayList<>();

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
    }
}
