package cn.tuyucheng.taketoday.jpa.simple;

import cn.tuyucheng.taketoday.jpa.simple.model.Book;
import cn.tuyucheng.taketoday.jpa.simple.repository.BookPagingAndSortingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookPagingAndSortingRepositoryIntegrationTest {

   @Autowired
   private BookPagingAndSortingRepository bookPagingAndSortingRepository;

   @Test
   void givenDbContainsBooks_whenfindBooksByAuthor_thenReturnBooksByAuthor() {
      Book book1 = new Book("Spring Data", "John Miller", "1234567890");
      Book book2 = new Book("Spring Data 2", "John Miller", "1234567891");
      Book book3 = new Book("Spring Data 3", "John Miller", "1234567892");
      bookPagingAndSortingRepository.saveAll(Arrays.asList(book1, book2, book3));

      Pageable pageable = PageRequest.of(0, 2, Sort.by("title").descending());
      List<Book> books = bookPagingAndSortingRepository.findBooksByAuthor("John Miller", pageable);
      assertEquals(2, books.size());
      assertEquals(book3.getId(), books.get(0).getId());
      assertEquals(book2.getId(), books.get(1).getId());
   }
}