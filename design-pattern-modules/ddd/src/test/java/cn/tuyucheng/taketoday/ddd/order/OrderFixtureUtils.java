package cn.tuyucheng.taketoday.ddd.order;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.List;

public class OrderFixtureUtils {
   public static List<OrderLine> anyOrderLines() {
      return List.of(new OrderLine(new Product(Money.of(CurrencyUnit.USD, 100)), 1));
   }

   public static List<OrderLine> orderLineItemsWorthNDollars(int totalCost) {
      return List.of(new OrderLine(new Product(Money.of(CurrencyUnit.USD, totalCost)), 1));
   }
}