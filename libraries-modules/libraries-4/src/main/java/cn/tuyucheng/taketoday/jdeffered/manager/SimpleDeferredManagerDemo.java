package cn.tuyucheng.taketoday.jdeffered.manager;

import org.jdeferred.DeferredManager;
import org.jdeferred.impl.DefaultDeferredManager;

class SimpleDeferredManagerDemo {

   public static void initiate() {
      DeferredManager dm = new DefaultDeferredManager();
      dm.when(() -> 1).done(_ -> System.out.println("done")).fail(Throwable::printStackTrace);
   }
}