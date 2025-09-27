package cn.tuyucheng.taketoday.specifications.join;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String firstName;

   private String lastName;

   @OneToMany(cascade = CascadeType.ALL)
   private List<BookAuthorEntity> bookAuthorEntities;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public List<BookAuthorEntity> getBookAuthorEntities() {
      return bookAuthorEntities;
   }

   public void setBookAuthorEntities(List<BookAuthorEntity> bookAuthorEntities) {
      this.bookAuthorEntities = bookAuthorEntities;
   }

   @Override
   public String toString() {
      return "Author{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", books=" + bookAuthorEntities + '}';
   }
}