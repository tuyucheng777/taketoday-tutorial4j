package cn.tuyucheng.taketoday.messaging.postgresql.service;

import cn.tuyucheng.taketoday.messaging.postgresql.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.PGConnection;
import org.postgresql.PGNotification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
public class NotifierService {
   private static final String ORDERS_CHANNEL = "orders";
   private final JdbcTemplate tpl;

   @Transactional
   public void notifyOrderCreated(Order order) {
      tpl.execute("NOTIFY " + ORDERS_CHANNEL + ", '" + order.getId() + "'");
   }

   public Runnable createNotificationHandler(Consumer<PGNotification> consumer) {

      return () -> {
         tpl.execute((Connection c) -> {
            LOGGER.info("notificationHandler: sending LISTEN command...");
            c.createStatement().execute("LISTEN " + ORDERS_CHANNEL);

            PGConnection pgconn = c.unwrap(PGConnection.class);

            while (!Thread.currentThread().isInterrupted()) {
               PGNotification[] nts = pgconn.getNotifications(10000);
               if (nts == null || nts.length == 0) {
                  continue;
               }

               for (PGNotification nt : nts) {
                  consumer.accept(nt);
               }
            }
            return 0;
         });
      };
   }
}