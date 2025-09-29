package cn.tuyucheng.taketoday.ex.mappingexception.cause1.persistence.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class Foo implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   public Foo() {
      super();
   }

   // API

   public long getId() {
      return id;
   }

   public void setId(final long id) {
      this.id = id;
   }
}