package cn.tuyucheng.taketoday.subflows.postgresqlnotify;

import cn.tuyucheng.taketoday.domain.Order;
import cn.tuyucheng.taketoday.domain.OrderType;
import cn.tuyucheng.taketoday.subflows.postgresqlnotify.PostgresqlPubSubExample.OrdersGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(classes = {PostgresqlPubSubExample.class})
public class PostgresqlPubSubExampleLiveTest {

   @Autowired
   PostgresqlPubSubExample processor;

   @Autowired
   OrdersGateway ordersGateway;

   @Test
   void whenPublishOrder_thenSuccess() throws Exception {
      Order o = new Order(1L, "BAEL", OrderType.BUY, BigDecimal.valueOf(2.0), BigDecimal.valueOf(5.0));
      ordersGateway.publish(o);

      assertThat(processor.awaitNextMessage(10, TimeUnit.SECONDS)).isTrue();

      BigDecimal total = processor.getTotalBySymbol("BAEL");
      assertThat(total).isEqualTo(BigDecimal.valueOf(10));
   }
}