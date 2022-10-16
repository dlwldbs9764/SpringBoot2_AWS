package aws.springboot.domain.posts;

import aws.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Getter, NoArgsConstrutor는 롬복 어노테이션이어서 덜 중요한 반면에, Entity는 Jpa 어노테이션이라 필수기 때문에
// 나중에 kotlin으로 코드룰 수정하거나 할때 필요없는 어노테이션 지우기 쉽도록 필수를 메소드에 가까이 놓는다.

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor // 기본 생성자 자동 추가 (=public Posts(){})
@Entity // 테이블과 링크될 클래스임을 나타낸다. entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
public class Posts extends BaseTimeEntity {
    @Id // 해당 테이블의 PK 필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타낸다.(Long, auto_increment 추천)
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    private String title;

    @Column(columnDefinition = "TEXt",nullable=false)
    private String content;

    private String author;

    @Builder // 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
