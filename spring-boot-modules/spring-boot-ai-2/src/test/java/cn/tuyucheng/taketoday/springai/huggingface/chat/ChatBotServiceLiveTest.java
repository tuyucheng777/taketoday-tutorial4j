package cn.tuyucheng.taketoday.springai.huggingface.chat;

import cn.tuyucheng.taketoday.springai.huggingface.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class ChatBotServiceLiveTest {

   @Autowired
   private ChatBotService chatBotService;

   @Test
   void whenChatBotCalledInSequence_thenConversationContextIsMaintained() {
      ChatRequest chatRequest = new ChatRequest(null, "Who wanted to kill Harry Potter?");
      ChatResponse chatResponse = chatBotService.chat(chatRequest);

      assertThat(chatResponse)
            .isNotNull()
            .satisfies(response -> {
               assertThat(response.chatId())
                     .isNotNull();
               assertThat(response.answer())
                     .containsAnyOf("Voldemort", "Tom Riddle");
            });

      ChatRequest followUpChatRequest = new ChatRequest(chatResponse.chatId(), "Who should he have gone after instead?");
      ChatResponse followUpChatResponse = chatBotService.chat(followUpChatRequest);

      assertThat(followUpChatResponse)
            .isNotNull()
            .satisfies(response -> {
               assertThat(response.answer())
                     .containsAnyOf("Neville", "Neville Longbottom");
            });
   }
}