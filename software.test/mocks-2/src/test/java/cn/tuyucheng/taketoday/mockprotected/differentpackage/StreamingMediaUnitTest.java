package cn.tuyucheng.taketoday.mockprotected.differentpackage;

import cn.tuyucheng.taketoday.mockprotected.Movies;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.support.ReflectionSupport;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;

class StreamingMediaUnitTest {

   @Test
   void givenProtectedMethod_whenMethodNotVisibleAndUseJUnitWithReflection_thenResponseIsStubbed() throws NoSuchMethodException {
      Movies matrix = Mockito.spy(new Movies("The Matrix"));
      assertThat(matrix.getPlaceHolder()).isEqualTo("Movie: The Matrix");

      ReflectionSupport.invokeMethod(Movies.class.getDeclaredMethod("getTitle"), doReturn("something else").when(matrix));

      assertThat(matrix.getPlaceHolder()).isEqualTo("Movie: something else");
   }

   @Test
   void givenProtectedMethod_whenMethodNotVisibleAndUseInnerTestClass_thenResponseIsStubbed() {
      MoviesWrapper matrix = Mockito.spy(new MoviesWrapper("The Matrix"));
      assertThat(matrix.getPlaceHolder()).isEqualTo("Movie: The Matrix");

      doReturn("something else").when(matrix)
            .getTitle();

      assertThat(matrix.getPlaceHolder()).isEqualTo("Movie: something else");
   }

   private static class MoviesWrapper extends Movies {
      public MoviesWrapper(String title) {
         super(title);
      }

      @Override
      protected String getTitle() {
         return super.getTitle();
      }
   }
}