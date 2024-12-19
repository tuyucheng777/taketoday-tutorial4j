package cn.tuyucheng.taketoday.spring.oracle.pooling;

import oracle.ucp.jdbc.PoolDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@SpringBootTest(classes = {SpringOraclePoolingApplication.class})
@ActiveProfiles({"oracle-pooling-basic"})
@TestPropertySource(properties = "spring.datasource.type=oracle.ucp.jdbc.PoolDataSource")
public class SpringOraclePoolingApplicationOracleUCPLiveTest {

   @Autowired
   private DataSource dataSource;

   @Test
   public void givenOracleUCPConfiguration_thenBuildsOraclePoolDataSource() {
      assertInstanceOf(PoolDataSource.class, dataSource);
   }
}