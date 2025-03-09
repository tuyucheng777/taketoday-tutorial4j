package cn.tuyucheng.taketoday.hibernate;


import cn.tuyucheng.taketoday.hibernate.basicannotation.Course;
import cn.tuyucheng.taketoday.hibernate.persistmaps.mapkey.User;
import cn.tuyucheng.taketoday.hibernate.persistmaps.mapkeyjoincolumn.Item;
import cn.tuyucheng.taketoday.hibernate.persistmaps.mapkeyjoincolumn.Order;
import cn.tuyucheng.taketoday.hibernate.persistmaps.mapkeyjoincolumn.Seller;

import java.util.Arrays;
import java.util.List;

public enum Strategy {
   // See that the classes belongs to different packages
   MAP_KEY_COLUMN_BASED(Arrays.asList(cn.tuyucheng.taketoday.hibernate.persistmaps.mapkeycolumn.Order.class,
         Course.class)),
   MAP_KEY_BASED(Arrays.asList(cn.tuyucheng.taketoday.hibernate.persistmaps.mapkey.Item.class,
         cn.tuyucheng.taketoday.hibernate.persistmaps.mapkey.Order.class, User.class)),
   MAP_KEY_JOIN_COLUMN_BASED(Arrays.asList(Seller.class,
         Item.class,
         Order.class)),
   MAP_KEY_ENUMERATED_BASED(Arrays.asList(cn.tuyucheng.taketoday.hibernate.persistmaps.mapkeyenumerated.Order.class,
         cn.tuyucheng.taketoday.hibernate.persistmaps.mapkey.Item.class)),
   MAP_KEY_TEMPORAL_BASED(Arrays.asList(cn.tuyucheng.taketoday.hibernate.persistmaps.mapkeytemporal.Order.class,
         cn.tuyucheng.taketoday.hibernate.persistmaps.mapkey.Item.class));


   private List<Class<?>> entityClasses;

   Strategy(List<Class<?>> entityClasses) {
      this.entityClasses = entityClasses;
   }

   public List<Class<?>> getEntityClasses() {
      return entityClasses;
   }
}
