package cn.tuyucheng.taketoday.tomcatconnectionpool.test.application;

import cn.tuyucheng.taketoday.tomcatconnectionpool.application.SpringBootConsoleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {SpringBootConsoleApplication.class})
@TestPropertySource(properties = "spring.datasource.type=org.apache.tomcat.jdbc.pool.DataSource")
class SpringBootTomcatConnectionPoolIntegrationTest {

   @Autowired
   private DataSource dataSource;

   @Test
   void givenTomcatConnectionPoolInstance_whenCheckedPoolClassName_thenCorrect() {
      assertThat(dataSource.getClass().getName()).isEqualTo("org.apache.tomcat.jdbc.pool.DataSource");
   }
}