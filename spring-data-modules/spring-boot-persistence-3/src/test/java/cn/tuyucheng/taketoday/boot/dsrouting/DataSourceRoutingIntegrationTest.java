package cn.tuyucheng.taketoday.boot.dsrouting;

import cn.tuyucheng.taketoday.dsrouting.ClientDatabase;
import cn.tuyucheng.taketoday.dsrouting.ClientDatabaseContextHolder;
import cn.tuyucheng.taketoday.dsrouting.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DataSourceRoutingTestConfiguration.class)
@DirtiesContext
public class DataSourceRoutingIntegrationTest {

   @Autowired
   DataSource routingDatasource;

   @Autowired
   ClientService clientService;

   @Before
   public void setup() {
      final String SQL_CLIENT_A = "insert into client (id, name) values (1, 'CLIENT A')";
      final String SQL_CLIENT_B = "insert into client (id, name) values (2, 'CLIENT B')";

      JdbcTemplate jdbcTemplate = new JdbcTemplate();
      jdbcTemplate.setDataSource(routingDatasource);

      ClientDatabaseContextHolder.set(ClientDatabase.CLIENT_A);
      jdbcTemplate.execute(SQL_CLIENT_A);
      ClientDatabaseContextHolder.clear();

      ClientDatabaseContextHolder.set(ClientDatabase.CLIENT_B);
      jdbcTemplate.execute(SQL_CLIENT_B);
      ClientDatabaseContextHolder.clear();
   }

   @Test
   public void givenClientDbs_whenContextsSwitch_thenRouteToCorrectDatabase() throws Exception {
      // test ACME WIDGETS
      String clientName = clientService.getClientName(ClientDatabase.CLIENT_A);
      assertEquals("CLIENT A", clientName);

      // test WIDGETS_ARE_US
      clientName = clientService.getClientName(ClientDatabase.CLIENT_B);
      assertEquals("CLIENT B", clientName);
   }
}