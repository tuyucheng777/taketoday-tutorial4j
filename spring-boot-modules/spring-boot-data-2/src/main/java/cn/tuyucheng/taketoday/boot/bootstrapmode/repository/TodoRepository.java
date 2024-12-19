package cn.tuyucheng.taketoday.boot.bootstrapmode.repository;

import org.springframework.data.repository.CrudRepository;

import cn.tuyucheng.taketoday.boot.bootstrapmode.domain.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}