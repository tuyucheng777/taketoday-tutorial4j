package cn.tuyucheng.taketoday.classtemplate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static java.lang.System.Logger;
import static java.lang.System.Logger.Level;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ClassTemplate
@ExtendWith(GreeterClassTemplateInvocationContextProvider.class)
class GreeterClassTemplateUnitTest {

   private static final Logger LOG = System.getLogger("GreeterClassTemplateUnitTest");

   private final String language;

   GreeterClassTemplateUnitTest(String language) {
      this.language = language;
   }

   @BeforeEach
   void logContext() {
      LOG.log(Level.INFO, () -> ">> Context: Language-" + language);
   }

   @Test
   void whenGreet_thenLocalizedMessage() {
      Greeter greeter = new Greeter();
      String actual = greeter.greet("Tuyucheng", language);

      assertEquals(
            "it".equals(language) ? "Ciao Tuyucheng" : "Hello Tuyucheng",
            actual
      );
   }
}