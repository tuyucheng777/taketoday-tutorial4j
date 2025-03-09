package cn.tuyucheng.taketoday.arrayscollections.repository;

import cn.tuyucheng.taketoday.arrayscollections.entity.MigratingUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MigratingUserRepository extends JpaRepository<MigratingUser, Long> {
}
