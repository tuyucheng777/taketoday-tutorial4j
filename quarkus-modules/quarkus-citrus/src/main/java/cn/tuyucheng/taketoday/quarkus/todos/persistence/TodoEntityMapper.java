package cn.tuyucheng.taketoday.quarkus.todos.persistence;

import org.mapstruct.Mapper;

import cn.tuyucheng.taketoday.quarkus.todos.domain.Todo;

@Mapper(componentModel = "cdi")
public interface TodoEntityMapper {

   TodoEntity map(Todo source);

   Todo map(TodoEntity source);
}