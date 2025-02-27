package cn.tuyucheng.taketoday.resource.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Foo {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   protected Foo() {
   }

   public Foo(String name) {
      this.name = name;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Foo other = (Foo) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      if (name == null) {
         return other.name == null;
      } else return name.equals(other.name);
   }

   @Override
   public String toString() {
      return "Foo [id=" + id + ", name=" + name + "]";
   }
}