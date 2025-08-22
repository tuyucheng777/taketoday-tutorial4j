package cn.tuyucheng.taketoday.springai.embeddings;

import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.openai.OpenAiEmbeddingModel;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ManualEmbeddingService {

   private final OpenAiEmbeddingModel openAiEmbeddingModel;

   public ManualEmbeddingService(OpenAiEmbeddingModel openAiEmbeddingModel) {
      this.openAiEmbeddingModel = openAiEmbeddingModel;
   }

   public EmbeddingResponse getEmbeddings(String... texts) {
      EmbeddingRequest request = new EmbeddingRequest(Arrays.asList(texts), null);
      return openAiEmbeddingModel.call(request);
   }
}