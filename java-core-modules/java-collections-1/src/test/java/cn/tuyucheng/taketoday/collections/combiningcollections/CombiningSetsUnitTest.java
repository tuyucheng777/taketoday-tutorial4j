package cn.tuyucheng.taketoday.collections.combiningcollections;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CombiningSetsUnitTest {
   private static final Set<Object> first = new HashSet<>(Arrays.asList("One", "Two", "Three"));

   private static final Set<Object> second = new HashSet<>(Arrays.asList("Four", "Five", "Six"));

   private static final Set<Object> expected = new HashSet<>(Arrays
         .asList("One", "Two", "Three", "Four", "Five", "Six"));

   @Test
   public void givenTwoSets_whenUsingNativeJava_thenArraysCombined() {
      assertThat(CombiningSets.usingNativeJava(first, second), is(expected));
   }

   @Test
   public void givenTwoSets_whenUsingObjectStreams_thenArraysCombined() {
      assertThat(CombiningSets.usingJava8ObjectStream(first, second), is(expected));
   }

   @Test
   public void givenTwoSets_whenUsingFlatMaps_thenArraysCombined() {
      assertThat(CombiningSets.usingJava8FlatMaps(first, second), is(expected));
   }

   @Test
   public void givenTwoSets_whenUsingApacheCommons_thenArraysCombined() {
      assertThat(CombiningSets.usingApacheCommons(first, second), is(expected));
   }

   @Test
   public void givenTwoSets_whenUsingGuava_thenArraysCombined() {
      assertThat(CombiningSets.usingGuava(first, second), is(expected));
   }
}