package cn.tuyucheng.taketoday.boot.daos.user;

import cn.tuyucheng.taketoday.boot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Integer> {

   Stream<User> findAllByName(String name);
}