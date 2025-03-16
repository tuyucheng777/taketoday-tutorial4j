package cn.tuyucheng.taketoday.customfunc;

import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CustomHibernateConfig implements HibernatePropertiesCustomizer {

   @Override
   public void customize(Map<String, Object> hibernateProperties) {
      hibernateProperties.put("hibernate.dialect", "cn.tuyucheng.taketoday.customfunc.CustomH2Dialect");
   }

}