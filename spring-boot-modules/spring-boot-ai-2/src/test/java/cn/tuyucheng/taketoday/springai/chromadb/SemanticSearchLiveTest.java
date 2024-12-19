package cn.tuyucheng.taketoday.springai.chromadb;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class SemanticSearchLiveTest {

   private static final int MAX_RESULTS = 3;

   @Autowired
   private VectorStore vectorStore;

   @ParameterizedTest
   @ValueSource(strings = {"Love and Romance", "Time and Mortality", "Jealousy and Betrayal"})
   void whenSearchingShakespeareTheme_thenRelevantPoemsReturned(String theme) {
      SearchRequest searchRequest = SearchRequest
            .query(theme)
            .withTopK(MAX_RESULTS);
      List<Document> documents = vectorStore.similaritySearch(searchRequest);

      assertThat(documents)
            .hasSizeLessThanOrEqualTo(MAX_RESULTS)
            .allSatisfy(document -> {
               String title = String.valueOf(document.getMetadata().get("title"));
               assertThat(title)
                     .isNotBlank();
            });
   }
}