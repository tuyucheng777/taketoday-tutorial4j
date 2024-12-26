package cn.tuyucheng.taketoday.util;

import org.testcontainers.containers.PostgreSQLContainer;

public class TaketodayPostgresqlContainer extends PostgreSQLContainer<TaketodayPostgresqlContainer> {

   private static final String IMAGE_VERSION = "postgres:11.1";

   private static TaketodayPostgresqlContainer container;


   private TaketodayPostgresqlContainer() {
      super(IMAGE_VERSION);
   }

   public static TaketodayPostgresqlContainer getInstance() {
      if (container == null) {
         container = new TaketodayPostgresqlContainer();
      }
      return container;
   }

   @Override
   public void start() {
      super.start();
      System.setProperty("DB_URL", container.getJdbcUrl());
      System.setProperty("DB_USERNAME", container.getUsername());
      System.setProperty("DB_PASSWORD", container.getPassword());
   }

   @Override
   public void stop() {
      // do nothing, JVM handles shut down
   }
}