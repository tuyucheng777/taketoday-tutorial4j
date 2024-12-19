package cn.tuyucheng.taketoday.spring.kafka.delay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

   private UUID orderId;

   private LocalDateTime orderGeneratedDateTime;

   private LocalDateTime orderProcessedTime;

   private List<String> address;

   private double price;
}