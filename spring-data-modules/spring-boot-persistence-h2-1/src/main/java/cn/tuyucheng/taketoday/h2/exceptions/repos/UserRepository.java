package cn.tuyucheng.taketoday.h2.exceptions.repos;

import cn.tuyucheng.taketoday.h2.exceptions.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}