package cn.tuyucheng.taketoday.rethinkdb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.rethinkdb.RethinkDB.r;

/**
 * Some tests demonstrating inserting data.
 */
public class InsertIntegrationLiveTest extends TestBase {
   /**
    * Create a table for the tests.
    */
   @BeforeEach
   public void createTable() {
      r.db(DB_NAME).tableCreate(tableName).run(conn);
   }

   /**
    * Insert a single simple record into the database.
    */
   @Test
   public void insertSimpleRecord() {
      r.db(DB_NAME).table(tableName)
            .insert(
                  r.hashMap()
                        .with("name", "Taketoday")
            )
            .run(conn);
   }

   @Test
   public void insertMap() {
      r.db(DB_NAME).table(tableName)
            .insert(
                  Map.of("name", "Taketoday")
            )
            .run(conn);
   }

   @Test
   public void insertComplex() {
      r.db(DB_NAME).table(tableName)
            .insert(
                  r.hashMap()
                        .with("name", "Taketoday")
                        .with("articles", r.array(
                                    r.hashMap()
                                          .with("name", "String Interpolation in Java")
                                          .with("url", "https://www.taketoday.com/java-string-interpolation"),
                                    r.hashMap()
                                          .with("name", "Access HTTPS REST Service Using Spring RestTemplate")
                                          .with("url", "https://www.taketoday.com/spring-resttemplate-secure-https-service")
                              )
                        )
            )
            .run(conn);
   }
}
