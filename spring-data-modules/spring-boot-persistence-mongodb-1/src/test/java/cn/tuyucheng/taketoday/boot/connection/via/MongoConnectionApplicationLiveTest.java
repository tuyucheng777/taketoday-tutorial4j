package cn.tuyucheng.taketoday.boot.connection.via;

import cn.tuyucheng.taketoday.boot.connection.via.client.SpringMongoConnectionViaClientApp;
import cn.tuyucheng.taketoday.boot.connection.via.properties.SpringMongoConnectionViaPropertiesApp;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MongoConnectionApplicationLiveTest {
   private static final String HOST = "localhost";
   private static final String PORT = "27017";
   private static final String DB = "taketoday";
   private static final String USER = "admin";
   private static final String PASS = "password";

   private void assertInsertSucceeds(ConfigurableApplicationContext context) {
      String name = "A";

      MongoTemplate mongo = context.getBean(MongoTemplate.class);
      Document doc = Document.parse("{\"name\":\"" + name + "\"}");
      Document inserted = mongo.insert(doc, "items");

      assertNotNull(inserted.get("_id"));
      assertEquals(name, inserted.get("name"));
   }

   @Test
   public void whenPropertiesConfig_thenInsertSucceeds() {
      SpringApplicationBuilder app = new SpringApplicationBuilder(SpringMongoConnectionViaPropertiesApp.class);
      app.run();

      assertInsertSucceeds(app.context());
   }

   @Test
   public void givenPrecedence_whenSystemConfig_thenInsertSucceeds() {
      System.setProperty("spring.data.mongodb.host", HOST);
      System.setProperty("spring.data.mongodb.port", PORT);
      System.setProperty("spring.data.mongodb.database", DB);
      System.setProperty("spring.data.mongodb.username", USER);
      System.setProperty("spring.data.mongodb.password", PASS);

      SpringApplicationBuilder app = new SpringApplicationBuilder(SpringMongoConnectionViaPropertiesApp.class)
            .properties(
                  "spring.data.mongodb.host=oldValue",
                  "spring.data.mongodb.port=oldValue",
                  "spring.data.mongodb.database=oldValue",
                  "spring.data.mongodb.username=oldValue",
                  "spring.data.mongodb.password=oldValue"
            );
      app.run();

      assertInsertSucceeds(app.context());
   }

   @Test
   public void givenConnectionUri_whenAlsoIncludingIndividualParameters_thenInvalidConfig() {
      System.setProperty(
            "spring.data.mongodb.uri",
            "mongodb://" + USER + ":" + PASS + "@" + HOST + ":" + PORT + "/" + DB
      );

      SpringApplicationBuilder app = new SpringApplicationBuilder(SpringMongoConnectionViaPropertiesApp.class)
            .properties(
                  "spring.data.mongodb.host=" + HOST,
                  "spring.data.mongodb.port=" + PORT,
                  "spring.data.mongodb.username=" + USER,
                  "spring.data.mongodb.password=" + PASS
            );

      BeanCreationException e = assertThrows(BeanCreationException.class, app::run);

      Throwable rootCause = e.getRootCause();
      assertInstanceOf(IllegalStateException.class, rootCause);
      assertThat(rootCause.getMessage()
            .contains("Invalid mongo configuration, either uri or host/port/credentials/replicaSet must be specified"));
   }

   @Test
   public void whenClientConfig_thenInsertSucceeds() {
      SpringApplicationBuilder app = new SpringApplicationBuilder(SpringMongoConnectionViaClientApp.class);
      app.web(WebApplicationType.NONE)
            .run(
                  "--spring.data.mongodb.uri=mongodb://" + USER + ":" + PASS + "@" + HOST + ":" + PORT + "/" + DB,
                  "--spring.data.mongodb.database=" + DB
            );

      assertInsertSucceeds(app.context());
   }
}