package cn.tuyucheng.taketoday.spring.cloud.bootstrap.svcbook.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

   @Autowired
   private BookService bookService;

   @GetMapping
   public List<Book> findAllBooks() {
      return bookService.findAllBooks();
   }

   @GetMapping("/{bookId}")
   public Book findBook(@PathVariable("bookId") Long bookId) {
      return bookService.findBookById(bookId);
   }

   @PostMapping
   public Book createBook(@RequestBody Book book) {
      return bookService.createBook(book);
   }

   @DeleteMapping("/{bookId}")
   public void deleteBook(@PathVariable("bookId") Long bookId) {
      bookService.deleteBook(bookId);
   }

   @PutMapping("/{bookId}")
   public Book updateBook(@RequestBody Book book, @PathVariable("bookId") Long bookId) {
      return bookService.updateBook(book, bookId);
   }

   @PatchMapping("/{bookId}")
   public Book updateBook(@RequestBody Map<String, String> updates, @PathVariable("bookId") Long bookId) {
      return bookService.updateBook(updates, bookId);
   }
}