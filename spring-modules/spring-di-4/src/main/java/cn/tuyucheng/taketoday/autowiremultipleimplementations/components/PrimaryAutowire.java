package cn.tuyucheng.taketoday.autowiremultipleimplementations.components;

import cn.tuyucheng.taketoday.autowiremultipleimplementations.candidates.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrimaryAutowire {

   private final GoodService goodService;

   @Autowired
   public PrimaryAutowire(GoodService goodService) {
      this.goodService = goodService;
   }

   public String hello() {
      return goodService.getHelloMessage();
   }
}