package cn.tuyucheng.taketoday.atomikos.spring;

import java.sql.Connection;
import java.sql.Statement;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.transaction.annotation.Transactional;

public class Application {

   private DataSource inventoryDataSource;
   private DataSource orderDataSource;

   public Application(DataSource inventoryDataSource, DataSource orderDataSource) {
      this.inventoryDataSource = inventoryDataSource;
      this.orderDataSource = orderDataSource;
   }

   @Transactional(rollbackFor = Exception.class)
   public void placeOrder(String productId, int amount) throws Exception {

      String orderId = UUID.randomUUID()
            .toString();
      Connection inventoryConnection = inventoryDataSource.getConnection();
      Connection orderConnection = orderDataSource.getConnection();
      Statement s1 = inventoryConnection.createStatement();
      String q1 = "update Inventory set balance = balance - " + amount + " where productId ='" + productId + "'";
      s1.executeUpdate(q1);
      s1.close();
      Statement s2 = orderConnection.createStatement();
      String q2 = "insert into Orders values ( '" + orderId + "', '" + productId + "', " + amount + " )";
      s2.executeUpdate(q2);
      s2.close();
      inventoryConnection.close();
      orderConnection.close();

   }

}
