package cn.tuyucheng.taketoday.springretry;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MyServiceImpl implements MyService {

   private static final Logger logger = LoggerFactory.getLogger(MyServiceImpl.class);

   @Override
   public void retryService() {
      logger.info("throw RuntimeException in method retryService()");
      throw new RuntimeException();
   }

   @Override
   public void retryServiceWithRecovery(String sql) throws SQLException {
      if (StringUtils.isEmpty(sql)) {
         logger.info("throw SQLException in method retryServiceWithRecovery()");
         throw new SQLException();
      }
   }

   @Override
   public void retryServiceWithCustomization(String sql) throws SQLException {
      if (StringUtils.isEmpty(sql)) {
         logger.info("throw SQLException in method retryServiceWithCustomization()");
         throw new SQLException();
      }
   }

   @Override
   public void retryServiceWithExternalConfiguration(String sql) throws SQLException {
      if (StringUtils.isEmpty(sql)) {
         logger.info("throw SQLException in method retryServiceWithExternalConfiguration()");
         throw new SQLException();
      }
   }

   @Override
   public void recover(SQLException e, String sql) {
      logger.info("In recover method");
   }

   @Override
   public void templateRetryService() {
      logger.info("throw RuntimeException in method templateRetryService()");
      throw new RuntimeException();
   }
}