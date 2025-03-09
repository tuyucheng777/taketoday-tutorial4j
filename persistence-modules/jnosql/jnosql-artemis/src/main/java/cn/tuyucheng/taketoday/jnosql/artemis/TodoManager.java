package cn.tuyucheng.taketoday.jnosql.artemis;

import java.util.List;

public interface TodoManager {

   Todo add(Todo todo);

   Todo get(String id);

   List<Todo> getAll();

   void delete(String id);
}
