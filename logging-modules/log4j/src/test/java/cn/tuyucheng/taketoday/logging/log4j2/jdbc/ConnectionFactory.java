package cn.tuyucheng.taketoday.logging.log4j2.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.Driver;

public class ConnectionFactory {
   private interface Singleton {
      ConnectionFactory INSTANCE = new ConnectionFactory();
   }

   private BasicDataSource dataSource;

   private ConnectionFactory() {
      dataSource = new BasicDataSource();
      dataSource.setDriver(new Driver());
      dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1;NON_KEYWORDS=WHEN");
   }

   public static Connection getConnection() throws SQLException {
      return Singleton.INSTANCE.dataSource.getConnection();
   }
}