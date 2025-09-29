package cn.tuyucheng.taketoday.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class IteratorAdapterUnitTest {

   public static final String STRING_DATA = "Welcome to tuyucheng.com";
   private final StringTokenizer tokenizer = new StringTokenizer(STRING_DATA);
   private final Iterator<String> tokenizerAdapter = new StringTokenizerIteratorAdapter(STRING_DATA);
   private final List<String> expectedTokensForString = Arrays.asList("Welcome", "to", "tuyucheng.com");

   @Test
   void givenTokenizer_thenAdapterProducesCorrectResult() {
      List<String> actualTokens = new ArrayList<>();
      new IteratorAdapter(tokenizer).forEachRemaining(s -> actualTokens.add((String) s));
      Assertions.assertEquals(expectedTokensForString, actualTokens);
   }

   @Test
   void givenTokenizerAdapter_thenIteratorProducesCorrectResult() {
      List<String> actualTokens = new ArrayList<>();
      tokenizerAdapter.forEachRemaining(actualTokens::add);
      Assertions.assertEquals(expectedTokensForString, actualTokens);
   }
}