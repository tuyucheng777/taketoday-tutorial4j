package cn.tuyucheng.taketoday.spring.cloud.client;

import cn.tuyucheng.taketoday.spring.cloud.model.Book;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static cn.tuyucheng.taketoday.spring.cloud.client.BookMocks.setupMockBooksResponse;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@EnableFeignClients
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WireMockConfig.class})
class BooksClientIntegrationTest {

   @Autowired
   private WireMockServer mockBooksService;

   @Autowired
   private WireMockServer mockBooksService2;

   @Autowired
   private BooksClient booksClient;

   @BeforeEach
   void setUp() throws IOException {
      setupMockBooksResponse(mockBooksService);
      setupMockBooksResponse(mockBooksService2);
   }

   @Test
   void whenGetBooks_thenBooksShouldBeReturned() {
      assertFalse(booksClient.getBooks().isEmpty());
   }

   @Test
   void whenGetBooks_thenTheCorrectBooksShouldBeReturned() {
      assertTrue(booksClient.getBooks()
            .containsAll(asList(
                  new Book("Dune", "Frank Herbert"),
                  new Book("Foundation", "Isaac Asimov"))));
   }
}