package cn.tuyucheng.taketoday.recordswithjpa.repository;

import cn.tuyucheng.taketoday.recordswithjpa.RecordsAsJpaIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookRepositoryIntegrationTest extends RecordsAsJpaIntegrationTest {

   @Test
   @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
   void findBookByAuthor() {
      assertEquals(2, bookRepository.findBookByAuthor("J.R.R. Tolkien").size());
   }

   @Test
   void findBookById() {
      assertEquals("The Lord of the Rings", bookRepository.findBookById(1L).title());
   }
}