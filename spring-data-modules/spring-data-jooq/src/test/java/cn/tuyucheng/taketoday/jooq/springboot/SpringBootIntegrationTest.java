package cn.tuyucheng.taketoday.jooq.springboot;

import cn.tuyucheng.taketoday.jooq.introduction.PersistenceContextIntegrationTest;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static cn.tuyucheng.taketoday.jooq.introduction.db.public_.tables.Author.AUTHOR;
import static cn.tuyucheng.taketoday.jooq.introduction.db.public_.tables.AuthorBook.AUTHOR_BOOK;
import static cn.tuyucheng.taketoday.jooq.introduction.db.public_.tables.Book.BOOK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ContextConfiguration(classes = PersistenceContextIntegrationTest.class)
@Transactional(transactionManager = "transactionManager")
@ExtendWith(SpringExtension.class)
class SpringBootIntegrationTest {

   @Autowired
   private DSLContext dsl;

   @Test
   void givenValidData_whenInserting_thenSucceed() {
      dsl.insertInto(AUTHOR)
            .set(AUTHOR.ID, 4)
            .set(AUTHOR.FIRST_NAME, "Herbert")
            .set(AUTHOR.LAST_NAME, "Schildt")
            .execute();

      dsl.insertInto(BOOK)
            .set(BOOK.ID, 4)
            .set(BOOK.TITLE, "A Beginner's Guide")
            .execute();

      dsl.insertInto(AUTHOR_BOOK)
            .set(AUTHOR_BOOK.AUTHOR_ID, 4)
            .set(AUTHOR_BOOK.BOOK_ID, 4)
            .execute();

      final Result<Record3<Integer, String, Integer>> result = dsl.select(AUTHOR.ID, AUTHOR.LAST_NAME, DSL.count())
            .from(AUTHOR).join(AUTHOR_BOOK).on(AUTHOR.ID.equal(AUTHOR_BOOK.AUTHOR_ID))
            .join(BOOK).on(AUTHOR_BOOK.BOOK_ID.equal(BOOK.ID))
            .groupBy(AUTHOR.LAST_NAME)
            .orderBy(AUTHOR.LAST_NAME.desc())
            .fetch();

      assertEquals(3, result.size());
      assertEquals("Sierra", result.getValue(0, AUTHOR.LAST_NAME));
      assertEquals(Integer.valueOf(2), result.getValue(0, DSL.count()));
      assertEquals("Bates", result.getValue(2, AUTHOR.LAST_NAME));
      assertEquals(Integer.valueOf(1), result.getValue(2, DSL.count()));
   }

   @Test
   void givenInvalidData_whenInserting_thenFail() {
      assertThrows(DataAccessException.class, () -> dsl.insertInto(AUTHOR_BOOK)
            .set(AUTHOR_BOOK.AUTHOR_ID, 4)
            .set(AUTHOR_BOOK.BOOK_ID, 5)
            .execute());
   }

   @Test
   void givenValidData_whenUpdating_thenSucceed() {
      dsl.update(AUTHOR)
            .set(AUTHOR.LAST_NAME, "Tuyucheng")
            .where(AUTHOR.ID.equal(3))
            .execute();

      dsl.update(BOOK)
            .set(BOOK.TITLE, "Building your REST API with Spring")
            .where(BOOK.ID.equal(3))
            .execute();

      dsl.insertInto(AUTHOR_BOOK)
            .set(AUTHOR_BOOK.AUTHOR_ID, 3)
            .set(AUTHOR_BOOK.BOOK_ID, 3)
            .execute();

      final Result<Record3<Integer, String, String>> result = dsl.select(AUTHOR.ID, AUTHOR.LAST_NAME, BOOK.TITLE)
            .from(AUTHOR).join(AUTHOR_BOOK).on(AUTHOR.ID.equal(AUTHOR_BOOK.AUTHOR_ID))
            .join(BOOK).on(AUTHOR_BOOK.BOOK_ID.equal(BOOK.ID))
            .where(AUTHOR.ID.equal(3))
            .fetch();

      assertEquals(1, result.size());
      assertEquals(Integer.valueOf(3), result.getValue(0, AUTHOR.ID));
      assertEquals("Tuyucheng", result.getValue(0, AUTHOR.LAST_NAME));
      assertEquals("Building your REST API with Spring", result.getValue(0, BOOK.TITLE));
   }

   @Test
   void givenInvalidData_whenUpdating_thenFail() {
      assertThrows(DataAccessException.class, () -> dsl.update(AUTHOR_BOOK)
            .set(AUTHOR_BOOK.AUTHOR_ID, 4)
            .set(AUTHOR_BOOK.BOOK_ID, 5)
            .execute());
   }

   @Test
   void givenValidData_whenDeleting_thenSucceed() {
      dsl.delete(AUTHOR)
            .where(AUTHOR.ID.lt(3))
            .execute();

      final Result<Record3<Integer, String, String>> result = dsl.select(AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
            .from(AUTHOR).fetch();

      assertEquals(1, result.size());
      assertEquals("Bryan", result.getValue(0, AUTHOR.FIRST_NAME));
      assertEquals("Basham", result.getValue(0, AUTHOR.LAST_NAME));
   }

   @Test
   void givenInvalidData_whenDeleting_thenFail() {
      assertThrows(DataAccessException.class, () -> dsl.delete(BOOK)
            .where(BOOK.ID.equal(1))
            .execute());
   }
}