package cn.tuyucheng.taketoday.starter.repository;

import cn.tuyucheng.taketoday.starter.domain.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> {
}
