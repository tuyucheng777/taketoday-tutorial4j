package cn.tuyucheng.taketoday.springai.embeddings;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmbeddingService {

   private final EmbeddingModel embeddingModel;

   public EmbeddingService(EmbeddingModel embeddingModel) {
      this.embeddingModel = embeddingModel;
   }

   public EmbeddingResponse getEmbeddings(String... texts) {
      EmbeddingRequest request = new EmbeddingRequest(Arrays.asList(texts), null);
      return embeddingModel.call(request);
   }
}