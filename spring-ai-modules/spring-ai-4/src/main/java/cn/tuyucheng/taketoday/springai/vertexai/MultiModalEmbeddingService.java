package cn.tuyucheng.taketoday.springai.vertexai;

import org.springframework.ai.content.Media;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.DocumentEmbeddingModel;
import org.springframework.ai.embedding.DocumentEmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;

import java.util.List;
import java.util.Map;

@Service
public class MultiModalEmbeddingService {

   private final DocumentEmbeddingModel documentEmbeddingModel;

   public MultiModalEmbeddingService(DocumentEmbeddingModel documentEmbeddingModel) {
      this.documentEmbeddingModel = documentEmbeddingModel;
   }

   public EmbeddingResponse getEmbedding(MimeType mimeType, Resource resource) {
      Document document = new Document(new Media(mimeType, resource), Map.of());
      DocumentEmbeddingRequest request = new DocumentEmbeddingRequest(List.of(document));
      return documentEmbeddingModel.call(request);
   }
}