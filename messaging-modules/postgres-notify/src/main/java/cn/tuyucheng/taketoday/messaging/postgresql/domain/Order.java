package cn.tuyucheng.taketoday.messaging.postgresql.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@ToString
@Table(name = "orders")
public class Order {
   @Id
   private Long id;
   private String symbol;
   private OrderType orderType;
   private BigDecimal price;
   private BigDecimal quantity;
}