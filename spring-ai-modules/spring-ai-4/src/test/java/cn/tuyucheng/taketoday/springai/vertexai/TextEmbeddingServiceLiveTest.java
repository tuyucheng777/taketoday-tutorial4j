package cn.tuyucheng.taketoday.springai.vertexai;

import org.junit.jupiter.api.Test;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("vertexai")
class TextEmbeddingServiceLiveTest {

   @Autowired
   private TextEmbeddingService embeddingService;

   @Test
   void whenGetEmbeddings_thenReturnEmbeddingResponse() {
      String text = "This is a test string for embedding.";
      EmbeddingResponse response = embeddingService.getEmbedding(text);
      assertThat(response).isNotNull();
      assertThat(response.getResults()).isNotNull();
      assertThat(response.getResults().isEmpty()).isFalse();
   }
}