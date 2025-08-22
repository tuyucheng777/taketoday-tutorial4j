package cn.tuyucheng.taketoday.eventuate.tram;

import cn.tuyucheng.taketoday.Application;
import cn.tuyucheng.taketoday.listener.TestKafkaListenerConfig;
import cn.tuyucheng.taketoday.listener.TestListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.ComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static java.time.Duration.ofSeconds;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testcontainers.shaded.org.awaitility.Awaitility.await;

@Testcontainers
@AutoConfigureMockMvc
@SpringBootTest(classes = {Application.class, TestKafkaListenerConfig.class})
@ActiveProfiles({"eventuate", "test-listeners"})
class EventuateTramLiveTest {

   @Container
   static ComposeContainer environment = new ComposeContainer(
         new File("src/test/resources/eventuate-docker-compose.yml"))
         .withLocalCompose(true);

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private TestListener testListener;

   @BeforeEach
   void setUp() {
      testListener.reset();
   }

   @Test
   void whenSavingAnEntityToDB_thenPublishKafkaEvent() throws Exception {
      String commentId = mockMvc.perform(post("/api/articles/oop-best-practices/comments")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content("""
                        {
                            "articleAuthor": "Andrey the Author",
                            "commentAuthor": "Richard the Reader",
                            "text": "Great article!"
                        }
                        """))
            .andExpect(status().is(201))
            .andReturn()
            .getResponse()
            .getContentAsString();

      await().atMost(ofSeconds(30))
            .until(() -> testListener.getCommentAddedEvents().size() == 1);

      String eventJson = testListener.getCommentAddedEvents().getFirst();
      assertThatJson(eventJson)
            .inPath("payload").asString()
            .isEqualToIgnoringWhitespace("""
                  {
                      "id": %s,
                      "articleSlug": "oop-best-practices"
                  }
                  """.formatted(commentId));
   }
}