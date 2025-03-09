package cn.tuyucheng.taketoday.spring.cloud.aws.sqs.fifo.model.entity;

import java.util.UUID;

public record Transaction(UUID transactionId, UUID accountId, double amount, TransactionType type) {
}