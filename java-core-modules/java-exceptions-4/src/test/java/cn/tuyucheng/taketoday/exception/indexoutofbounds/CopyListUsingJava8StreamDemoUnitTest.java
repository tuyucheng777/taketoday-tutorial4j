package cn.tuyucheng.taketoday.exception.indexoutofbounds;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CopyListUsingJava8StreamDemoUnitTest {

   @Test
   void whenCopyListUsingStream_thenMakeACopyOfArrayList() {
      List<Integer> source = Arrays.asList(11, 22, 33);

      assertEquals(source, CopyListUsingJava8StreamDemo.copyList(source));
   }
}
