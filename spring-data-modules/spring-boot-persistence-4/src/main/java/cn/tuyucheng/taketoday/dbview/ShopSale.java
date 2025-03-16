package cn.tuyucheng.taketoday.dbview;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "SHOP_SALE_VIEW")
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class ShopSale {

   @EmbeddedId
   @AttributeOverrides({
         @AttributeOverride(name = "shopId", column = @Column(name = "shop_id")),
         @AttributeOverride(name = "year", column = @Column(name = "transaction_year")),
         @AttributeOverride(name = "month", column = @Column(name = "transaction_month"))
   })
   private ShopSaleCompositeId id;

   @Column(name = "shop_location", length = 100)
   private String shopLocation;

   @Column(name = "total_amount")
   private BigDecimal totalAmount;

}