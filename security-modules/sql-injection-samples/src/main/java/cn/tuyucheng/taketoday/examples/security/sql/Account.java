package cn.tuyucheng.taketoday.examples.security.sql;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "Accounts")
@Data
public class Account {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String customerId;
   private String accNumber;
   private String branchId;
   private BigDecimal balance;
}