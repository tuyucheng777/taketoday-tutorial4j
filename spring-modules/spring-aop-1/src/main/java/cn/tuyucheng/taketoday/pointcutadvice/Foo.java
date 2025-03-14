package cn.tuyucheng.taketoday.pointcutadvice;

import cn.tuyucheng.taketoday.pointcutadvice.annotations.Entity;

@Entity
public class Foo {
   private Long id;
   private String name;

   public Foo(Long id, String name) {
      this.id = id;
      this.name = name;
   }

   @Override
   public String toString() {
      return "Foo{" + "id=" + id + ", name='" + name + '\'' + '}';
   }
}