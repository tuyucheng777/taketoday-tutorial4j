package cn.tuyucheng.taketoday.repository.user;

import cn.tuyucheng.taketoday.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}