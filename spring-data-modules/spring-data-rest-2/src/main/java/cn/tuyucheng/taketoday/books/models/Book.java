package cn.tuyucheng.taketoday.books.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(nullable = false)
   private String title;

   private String isbn;

   @ManyToOne
   @JoinColumn(name = "library_id")
   private Library library;

   @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
   private List<Author> authors;

   public Book() {
   }

   public Book(String title) {
      super();
      this.title = title;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getIsbn() {
      return isbn;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public Library getLibrary() {
      return library;
   }

   public void setLibrary(Library library) {
      this.library = library;
   }

   public List<Author> getAuthors() {
      return authors;
   }

   public void setAuthors(List<Author> authors) {
      this.authors = authors;
   }
}