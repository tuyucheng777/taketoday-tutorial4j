package cn.tuyucheng.taketoday.quarkus.todos.domain;

import java.util.Collection;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;

import cn.tuyucheng.taketoday.quarkus.shared.interceptors.FireEvent;
import cn.tuyucheng.taketoday.quarkus.shared.interceptors.Validated;
import cn.tuyucheng.taketoday.quarkus.todos.domain.TodoEvents.TodoCreated;

import lombok.RequiredArgsConstructor;

@Validated
@ApplicationScoped
@RequiredArgsConstructor
public class TodosService {

   private final TodosSink sink;

   public Collection<Todo> findAll() {
      return sink.findAll();
   }

   public Optional<Todo> findById(Long id) {
      return sink.findById(id);
   }

   @FireEvent(TodoCreated.class)
   public void add(@Valid Todo todo) {
      this.sink.add(todo);
   }
}