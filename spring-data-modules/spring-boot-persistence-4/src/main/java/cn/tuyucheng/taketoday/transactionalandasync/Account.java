package cn.tuyucheng.taketoday.transactionalandasync;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "account")
@Data
public class Account {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   @Column(name = "balance")
   private BigDecimal balance;
}