package cn.tuyucheng.taketoday.books.events;

import cn.tuyucheng.taketoday.books.models.Author;
import cn.tuyucheng.taketoday.books.models.Book;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class BookEventHandlerUnitTest {
   @Test
   public void whenCreateBookThenSuccess() {
      Book book = mock(Book.class);
      BookEventHandler bookEventHandler = new BookEventHandler();
      bookEventHandler.handleBookBeforeCreate(book);
      Mockito.verify(book, Mockito.times(1)).getAuthors();
   }

   @Test
   public void whenCreateAuthorThenSuccess() {
      Author author = mock(Author.class);
      BookEventHandler bookEventHandler = new BookEventHandler();
      bookEventHandler.handleAuthorBeforeCreate(author);
      Mockito.verify(author, Mockito.times(1)).getBooks();
   }
}