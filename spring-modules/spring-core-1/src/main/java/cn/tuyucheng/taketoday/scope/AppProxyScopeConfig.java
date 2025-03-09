package cn.tuyucheng.taketoday.scope;

import cn.tuyucheng.taketoday.scope.prototype.PrototypeBean;
import cn.tuyucheng.taketoday.scope.singleton.SingletonBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("cn.tuyucheng.taketoday.scope")
public class AppProxyScopeConfig {

   @Bean
   @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
   public PrototypeBean prototypeBean() {
      return new PrototypeBean();
   }

   @Bean
   public SingletonBean singletonBean() {
      return new SingletonBean();
   }
}