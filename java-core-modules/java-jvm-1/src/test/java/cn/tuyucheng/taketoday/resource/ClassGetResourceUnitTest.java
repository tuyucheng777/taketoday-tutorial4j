package cn.tuyucheng.taketoday.resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;

class ClassGetResourceUnitTest {

   @Test
   void givenRelativeResourcePath_whenGetResource_thenReturnResource() {
      URL resourceRelativePath = ClassGetResourceExample.class.getResource("example.txt");
      Assertions.assertNotNull(resourceRelativePath);
   }

   @Test
   void givenAbsoluteResourcePath_whenGetResource_thenReturnResource() {
      URL resourceAbsolutePath = ClassGetResourceExample.class.getResource("/cn/tuyucheng/taketoday/resource/example.txt");
      Assertions.assertNotNull(resourceAbsolutePath);
   }
}
