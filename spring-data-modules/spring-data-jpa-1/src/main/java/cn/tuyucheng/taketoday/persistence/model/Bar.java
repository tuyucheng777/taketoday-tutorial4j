package cn.tuyucheng.taketoday.persistence.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;

import java.io.Serializable;
import java.util.List;

@Entity
public class Bar implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Column(nullable = false)
   private String name;

   @OneToMany(mappedBy = "bar", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @OrderBy("name ASC")
   List<Foo> fooList;

   public Bar() {
      super();
   }

   public Bar(final String name) {
      super();

      this.name = name;
   }

   // API

   public long getId() {
      return id;
   }

   public void setId(final long id) {

      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public List<Foo> getFooList() {
      return fooList;
   }

   public void setFooList(final List<Foo> fooList) {
      this.fooList = fooList;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(final Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      final Bar other = (Bar) obj;
      if (name == null) {
         return other.name == null;
      } else return name.equals(other.name);
   }

   @Override
   public String toString() {
      return "Bar [name=" + name + "]";
   }
}