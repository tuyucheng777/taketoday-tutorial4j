package cn.tuyucheng.taketoday.apache.opennlp;

import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.junit.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerUnitTest {

   @Test
   public void givenEnglishModel_whenTokenize_thenTokensAreDetected() throws Exception {
      InputStream inputStream = getClass().getResourceAsStream("/models/en-token.bin");
      TokenizerModel model = new TokenizerModel(inputStream);
      TokenizerME tokenizer = new TokenizerME(model);
      String[] tokens = tokenizer.tokenize("Taketoday is a Spring Resource.");
      assertThat(tokens).contains("Taketoday", "is", "a", "Spring", "Resource", ".");
   }

   @Test
   public void givenWhitespaceTokenizer_whenTokenize_thenTokensAreDetected() throws Exception {
      WhitespaceTokenizer tokenizer = WhitespaceTokenizer.INSTANCE;
      String[] tokens = tokenizer.tokenize("Taketoday is a Spring Resource.");
      assertThat(tokens).contains("Taketoday", "is", "a", "Spring", "Resource.");
   }

   @Test
   public void givenSimpleTokenizer_whenTokenize_thenTokensAreDetected() throws Exception {
      SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
      String[] tokens = tokenizer.tokenize("Taketoday is a Spring Resource.");
      assertThat(tokens).contains("Taketoday", "is", "a", "Spring", "Resource", ".");
   }
}