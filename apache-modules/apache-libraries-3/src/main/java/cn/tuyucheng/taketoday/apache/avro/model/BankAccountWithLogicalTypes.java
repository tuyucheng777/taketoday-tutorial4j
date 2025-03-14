package cn.tuyucheng.taketoday.apache.avro.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record BankAccountWithLogicalTypes(String bankAccountNumber, UUID reference, LocalDateTime expiryDate) {
}