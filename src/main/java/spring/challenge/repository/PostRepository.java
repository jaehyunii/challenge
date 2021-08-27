package spring.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.challenge.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
