package cn.tuyucheng.taketoday.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class MyBeanFactory implements BeanFactoryAware {

   private BeanFactory beanFactory;

   @Override
   public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
      this.beanFactory = beanFactory;
   }

   public void getMyBeanName() {
      MyBeanName myBeanName = beanFactory.getBean(MyBeanName.class);
      System.out.println(beanFactory.isSingleton("myCustomBeanName"));
   }
}