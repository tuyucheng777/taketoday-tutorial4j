package cn.tuyucheng.taketoday.dataframes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerDataAggregationPipelineLiveTest {

   private static Connection conn;

   @BeforeAll
   static void beforeAll() throws SQLException {
      DriverManager.registerDriver(new org.postgresql.Driver());
      String dbURL1 = "jdbc:postgresql://localhost:5432/customerdb";
      conn = DriverManager.getConnection(dbURL1, "postgres", "postgres");

      String sql = "drop table if exists customer";

      PreparedStatement statement = conn.prepareStatement(sql);
      statement.executeUpdate();
   }

   @Test
   void givenCSVAndJSON_whenRun_thenStoresAggregatedDataFrameInDB() throws Exception {
      Properties dbProps = new Properties();
      dbProps.setProperty("connectionURL", "jdbc:postgresql://localhost:5432/customerdb");
      dbProps.setProperty("driver", "org.postgresql.Driver");
      dbProps.setProperty("user", "postgres");
      dbProps.setProperty("password", "postgres");

      CustomerDataAggregationPipeline pipeline = new CustomerDataAggregationPipeline(dbProps);
      pipeline.run();

      String allCustomersSql = "Select count(*) from customer";

      Statement statement = conn.createStatement();
      ResultSet resultSet = statement.executeQuery(allCustomersSql);
      resultSet.next();
      int count = resultSet.getInt(1);
      assertEquals(7, count);
   }
}