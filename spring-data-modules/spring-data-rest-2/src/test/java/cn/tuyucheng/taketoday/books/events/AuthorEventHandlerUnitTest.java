package cn.tuyucheng.taketoday.books.events;

import cn.tuyucheng.taketoday.books.models.Author;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class AuthorEventHandlerUnitTest {

   @Test
   public void whenCreateAuthorThenSuccess() {
      Author author = mock(Author.class);
      AuthorEventHandler authorEventHandler = new AuthorEventHandler();
      authorEventHandler.handleAuthorBeforeCreate(author);
      Mockito.verify(author, Mockito.times(1)).getName();
   }

   @Test
   public void whenDeleteAuthorThenSuccess() {
      Author author = mock(Author.class);
      AuthorEventHandler authorEventHandler = new AuthorEventHandler();
      authorEventHandler.handleAuthorAfterDelete(author);
      Mockito.verify(author, Mockito.times(1)).getName();
   }
}