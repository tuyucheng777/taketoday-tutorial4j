package cn.tuyucheng.taketoday.boot.domain;

import javax.persistence.*;

@Entity
@Table
public class Possession {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   private String name;

   public Possession() {
      super();
   }

   public Possession(final String name) {
      super();

      this.name = name;
   }

   public long getId() {
      return id;
   }

   public void setId(final int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = (prime * result) + (int) (id ^ (id >>> 32));
      result = (prime * result) + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final Possession other = (Possession) obj;
      if (id != other.id) {
         return false;
      }
      if (name == null) {
         return other.name == null;
      } else return name.equals(other.name);
   }

   @Override
   public String toString() {
      return "Possesion [id=" + id + ", name=" + name + "]";
   }
}