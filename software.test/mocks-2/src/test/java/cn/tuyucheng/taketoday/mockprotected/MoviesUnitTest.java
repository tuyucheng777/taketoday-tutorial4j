package cn.tuyucheng.taketoday.mockprotected;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

class MoviesUnitTest {

   @Test
   void givenProtectedMethod_whenMethodIsVisibleAndUseMockitoToStub_thenResponseIsStubbed() {
      Movies matrix = Mockito.spy(new Movies("The Matrix"));
      assertThat(matrix.getPlaceHolder()).isEqualTo("Movie: The Matrix");

      doReturn("something else").when(matrix)
            .getTitle();

      assertThat(matrix.getTitle()).isEqualTo("something else");
      assertThat(matrix.getPlaceHolder()).isEqualTo("Movie: something else");
   }
}