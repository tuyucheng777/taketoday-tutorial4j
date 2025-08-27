package cn.tuyucheng.taketoday.springsecurity.repository;

import cn.tuyucheng.taketoday.springsecurity.entity.Post;
import cn.tuyucheng.taketoday.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
   List<Post> findByUser(User user);
}