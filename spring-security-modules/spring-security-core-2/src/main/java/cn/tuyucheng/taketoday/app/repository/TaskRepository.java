package cn.tuyucheng.taketoday.app.repository;

import org.springframework.data.repository.CrudRepository;

import cn.tuyucheng.taketoday.app.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
}