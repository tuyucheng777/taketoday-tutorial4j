package cn.tuyucheng.taketoday.spring.notamanagedtype.missedentityscan.repository;

import cn.tuyucheng.taketoday.spring.notamanagedtype.missedentityscan.entity.CorrectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrectEntityRepository extends JpaRepository<CorrectEntity, Long> {

}
