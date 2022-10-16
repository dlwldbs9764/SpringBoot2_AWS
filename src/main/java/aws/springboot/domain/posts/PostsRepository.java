package aws.springboot.domain.posts;

import aws.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> { // JpaRepository<Entity 클래스, PK타입> -> CRUD 메소드 자동 생성
    // 이게 끝 ㅋㅋ
}
