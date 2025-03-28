package cn.tuyucheng.taketoday.books.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(nullable = false)
   private String name;

   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
   private List<Book> books;

   public Author() {
   }

   public Author(String name) {
      super();
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public List<Book> getBooks() {
      return books;
   }

   public void setBooks(List<Book> books) {
      this.books = books;
   }
}