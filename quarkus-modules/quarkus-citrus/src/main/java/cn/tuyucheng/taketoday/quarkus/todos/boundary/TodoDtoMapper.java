package cn.tuyucheng.taketoday.quarkus.todos.boundary;

import org.mapstruct.Mapper;

import cn.tuyucheng.taketoday.quarkus.todos.domain.Todo;

@Mapper(componentModel = "cdi")
public interface TodoDtoMapper {

   TodoDto map(Todo source);

   Todo map(TodoDto source);
}