package cn.tuyucheng.taketoday.security.repository;

import cn.tuyucheng.taketoday.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

   boolean existsByEmailId(final String emailId);
}