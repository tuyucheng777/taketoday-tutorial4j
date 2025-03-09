package cn.tuyucheng.taketoday.neo4j;

import static cn.tuyucheng.taketoday.neo4j.TestContainersTestBase.DEFAULT_PASSWORD;
import static cn.tuyucheng.taketoday.neo4j.TestContainersTestBase.getNewBoltConnection;
import static cn.tuyucheng.taketoday.neo4j.TestContainersTestBase.neo4jServer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;


/**
 * To run this test you will need to have an instance of the docker running on your machine (Docker desktop - for Windows and Docker instance for linux)
 * After your docker instance is up run this test
 */
class Neo4JServerLiveTest {

   private static Session session;
   private static Driver driver;

   @BeforeAll
   public static void setup() {
      driver = getNewBoltConnection();
   }

   @AfterAll
   public static void tearDown() {
      driver.close();
   }

   @Test
   void standAloneDriver() {
      session = driver.session();
      session.run("CREATE (taketoday:Company {name:\"Taketoday\"}) " +
            "-[:owns]-> (tesla:Car {make: 'tesla', model: 'modelX'})" +
            "RETURN taketoday, tesla");

      Result result = session.run("MATCH (company:Company)-[:owns]-> (car:Car)" +
            "WHERE car.make='tesla' and car.model='modelX'" +
            "RETURN company.name");

      assertTrue(result.hasNext());
      assertEquals("Taketoday", result.next().get("company.name").asString());

      session.close();
   }

   @Test
   void standAloneJdbc() throws Exception {
      String uri = "jdbc:neo4j:" + neo4jServer.getBoltUrl() + "/?user=neo4j,password=" + DEFAULT_PASSWORD + ",scheme=basic";
      Connection con = DriverManager.getConnection(uri);

      // Querying
      try (Statement stmt = con.createStatement()) {
         stmt.execute("CREATE (taketoday:Company {name:\"Taketoday\"}) " +
               "-[:owns]-> (tesla:Car {make: 'tesla', model: 'modelX'})" +
               "RETURN taketoday, tesla");

         ResultSet rs = stmt.executeQuery("MATCH (company:Company)-[:owns]-> (car:Car)" +
               "WHERE car.make='tesla' and car.model='modelX'" +
               "RETURN company.name");

         while (rs.next()) {
            assertEquals("Taketoday", rs.getString("company.name"));
         }
      }
      con.close();
   }
}
