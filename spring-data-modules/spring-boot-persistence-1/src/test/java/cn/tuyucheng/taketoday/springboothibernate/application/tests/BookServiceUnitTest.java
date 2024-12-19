package cn.tuyucheng.taketoday.springboothibernate.application.tests;

import cn.tuyucheng.taketoday.springboothibernate.application.models.Book;
import cn.tuyucheng.taketoday.springboothibernate.application.services.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceUnitTest {

   @Autowired
   private BookService bookService;

   @Test
   public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
      List<Book> books = bookService.list();

      Assert.assertEquals(3, books.size());
   }
}