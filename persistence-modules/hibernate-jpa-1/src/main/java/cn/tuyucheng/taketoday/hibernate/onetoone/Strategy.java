package cn.tuyucheng.taketoday.hibernate.onetoone;


import cn.tuyucheng.taketoday.hibernate.onetoone.foreignkeybased.Address;
import cn.tuyucheng.taketoday.hibernate.onetoone.foreignkeybased.User;
import cn.tuyucheng.taketoday.hibernate.onetoone.jointablebased.Employee;
import cn.tuyucheng.taketoday.hibernate.onetoone.jointablebased.WorkStation;

import java.util.Arrays;
import java.util.List;

public enum Strategy {
   // See that the classes belongs to different packages
   FOREIGN_KEY(Arrays.asList(User.class,
         Address.class)),
   SHARED_PRIMARY_KEY(Arrays.asList(cn.tuyucheng.taketoday.hibernate.onetoone.sharedkeybased.User.class,
         cn.tuyucheng.taketoday.hibernate.onetoone.sharedkeybased.Address.class)),
   JOIN_TABLE_BASED(Arrays.asList(Employee.class,
         WorkStation.class));

   private List<Class<?>> entityClasses;

   Strategy(List<Class<?>> entityClasses) {
      this.entityClasses = entityClasses;
   }

   public List<Class<?>> getEntityClasses() {
      return entityClasses;
   }
}
