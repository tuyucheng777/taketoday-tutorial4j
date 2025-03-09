package cn.tuyucheng.taketoday.beanpostprocessor;

import java.lang.annotation.*;

/**
 * An annotation which indicates which Guava {@link com.google.common.eventbus.EventBus} a Spring bean wishes to subscribe to.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Subscriber {

   /**
    * A SpEL expression which selects the {@link com.google.common.eventbus.EventBus}.
    */
   String value() default GlobalEventBus.GLOBAL_EVENT_BUS_EXPRESSION;
}