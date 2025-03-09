package cn.tuyucheng.taketoday.scope.singleton;

import cn.tuyucheng.taketoday.scope.prototype.PrototypeBean;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class SingletonLookupBean {

   @Lookup
   public PrototypeBean getPrototypeBean() {
      return null;
   }
}