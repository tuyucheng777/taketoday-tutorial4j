package cn.tuyucheng.taketoday.skipselectbeforeinsert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.tuyucheng.taketoday.skipselectbeforeinsert.model.TaskWithGeneratedId;

@Repository
public interface TaskWithGeneratedIdRepository extends JpaRepository<TaskWithGeneratedId, Integer> {
}