package cn.tuyucheng.taketoday.scope.singleton;

import cn.tuyucheng.taketoday.scope.prototype.PrototypeBean;
import jakarta.inject.Provider;
import org.springframework.beans.factory.annotation.Autowired;

public class SingletonProviderBean {

   @Autowired
   private Provider<PrototypeBean> myPrototypeBeanProvider;

   public PrototypeBean getPrototypeInstance() {
      return myPrototypeBeanProvider.get();
   }
}