package cn.tuyucheng.taketoday.multipledb.dao.user;

import cn.tuyucheng.taketoday.multipledb.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}