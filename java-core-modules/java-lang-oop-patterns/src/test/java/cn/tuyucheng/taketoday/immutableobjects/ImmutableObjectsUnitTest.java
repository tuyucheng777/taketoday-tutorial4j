package cn.tuyucheng.taketoday.immutableobjects;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ImmutableObjectsUnitTest {

   @Test
   public void whenCallingStringReplace_thenStringDoesNotMutate() {
      // 2. What's an Immutable Object?
      final String name = "taketoday";
      final String newName = name.replace("dung", "----");

      assertEquals("taketoday", name);
      assertEquals("bael----", newName);
   }

   public void whenReassignFinalValue_thenCompilerError() {
      // 3. The final Keyword in Java (1)
      final String name = "taketoday";
      // name = "bael...";
   }

   @Test
   public void whenAddingElementToList_thenSizeChange() {
      // 3. The final Keyword in Java (2)
      final List<String> strings = new ArrayList<>();
      assertEquals(0, strings.size());
      strings.add("taketoday");
      assertEquals(1, strings.size());
   }
}
