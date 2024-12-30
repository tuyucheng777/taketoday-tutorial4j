package cn.tuyucheng.taketoday.commons.beanutils;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

public class IgnoreNullBeanUtilsBean extends BeanUtilsBean {

   @Override
   public void copyProperty(Object dest, String name, Object value) throws IllegalAccessException, InvocationTargetException {
      if (value != null) {
         super.copyProperty(dest, name, value);
      }
   }
}