package cn.tuyucheng.taketoday.destroyprototypebean.destroymethod;

import cn.tuyucheng.taketoday.destroyprototypebean.destorymethod.CustomMethodBeanExample;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "cn.tuyucheng.taketoday.destroyprototypebean.destroymethod")
public class DestroyMethodConfig {

   @Bean(destroyMethod = "destroy")
   @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
   public CustomMethodBeanExample customMethodBeanExample() {
      return new CustomMethodBeanExample();
   }
}