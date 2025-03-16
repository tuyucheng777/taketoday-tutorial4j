package cn.tuyucheng.taketoday.dbview;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ShopSaleCompositeId {

   private int shopId;

   private int year;

   private int month;

}
