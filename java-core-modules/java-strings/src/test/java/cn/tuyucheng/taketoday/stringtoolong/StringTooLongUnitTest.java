package cn.tuyucheng.taketoday.stringtoolong;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTooLongUnitTest {
   @Test
   public void whenDeclaringTooLongString_thenCompilationError() {
      String stringTooLong = "<string too long>";
      assertThat(stringTooLong).isNotEmpty();
   }

   @Test
   public void whenStoringInFileTooLongString_thenNoCompilationError() throws IOException {
      FileInputStream fis = new FileInputStream("src/test/resources/stringtoolong.txt");
      String stringTooLong = IOUtils.toString(fis, "UTF-8");
      assertThat(stringTooLong).isNotEmpty();
   }

   @Test
   public void whenStoringInPropertiesString_thenNoCompilationError() throws IOException {
      String sValue = null;
      try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
         Properties prop = new Properties();
         prop.load(input);
         sValue = prop.getProperty("string.too.long");
      }
      assertThat(sValue).isNotEmpty();
   }
}
