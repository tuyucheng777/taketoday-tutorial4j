package cn.tuyucheng.taketoday.books.models;

import jakarta.persistence.*;

@Entity
public class Address {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(nullable = false)
   private String location;

   @OneToOne(mappedBy = "address")
   private Library library;

   public Address() {
   }

   public Address(String location) {
      super();
      this.location = location;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public Library getLibrary() {
      return library;
   }

   public void setLibrary(Library library) {
      this.library = library;
   }
}