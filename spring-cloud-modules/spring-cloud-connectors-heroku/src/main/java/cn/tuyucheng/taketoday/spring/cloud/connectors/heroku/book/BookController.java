package cn.tuyucheng.taketoday.spring.cloud.connectors.heroku.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

   private final BookService bookService;

   @Autowired
   public BookController(BookService bookService) {
      this.bookService = bookService;
   }

   @GetMapping("/{bookId}")
   public Optional<Book> findBook(@PathVariable Long bookId) {
      return bookService.findBookById(bookId);
   }

   @PostMapping
   public Book createBook(@RequestBody Book book) {
      return bookService.createBook(book);
   }
}