package cn.tuyucheng.taketoday.pointcutadvice.dao;

import cn.tuyucheng.taketoday.pointcutadvice.Foo;
import cn.tuyucheng.taketoday.pointcutadvice.annotations.Loggable;
import org.springframework.stereotype.Repository;

@Repository
public class FooDao {

   public String findById(Long id) {
      return "Bazz";
   }

   @Loggable
   public Foo create(Long id, String name) {
      return new Foo(id, name);
   }

   public Foo merge(Foo foo) {
      return foo;
   }
}