package cn.tuyucheng.taketoday.dynamicquery.repository;

import cn.tuyucheng.taketoday.dynamicquery.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}