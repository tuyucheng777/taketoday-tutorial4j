package cn.tuyucheng.taketoday.beanvalidation.application.repositories;

import cn.tuyucheng.taketoday.beanvalidation.application.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
   AppUser findByUsername(String username);
}