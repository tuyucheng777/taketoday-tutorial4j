package cn.tuyucheng.taketoday.hikari;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HikariIntegrationTest {

   @Autowired
   private DataSource dataSource;

   @Test
   public void hikariConnectionPoolIsConfigured() {
      assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass()
            .getName());
   }

}
