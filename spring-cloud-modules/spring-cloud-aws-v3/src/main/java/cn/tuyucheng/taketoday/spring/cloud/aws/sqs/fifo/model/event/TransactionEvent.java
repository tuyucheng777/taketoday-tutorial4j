package cn.tuyucheng.taketoday.spring.cloud.aws.sqs.fifo.model.event;

import cn.tuyucheng.taketoday.spring.cloud.aws.sqs.fifo.model.entity.Transaction;
import cn.tuyucheng.taketoday.spring.cloud.aws.sqs.fifo.model.entity.TransactionType;

import java.util.UUID;

public record TransactionEvent(UUID transactionId, UUID accountId, double amount, TransactionType type) {

   public Transaction toEntity() {
      return new Transaction(transactionId, accountId, amount, type);
   }
}