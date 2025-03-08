package cn.tuyucheng.taketoday.countrows.repository;

import cn.tuyucheng.taketoday.countrows.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
   Permission findByType(String type);
}