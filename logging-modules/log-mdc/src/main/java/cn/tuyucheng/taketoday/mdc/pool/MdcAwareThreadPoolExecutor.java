package cn.tuyucheng.taketoday.mdc.pool;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.MDC;

import java.util.concurrent.*;

public class MdcAwareThreadPoolExecutor extends ThreadPoolExecutor {

   public MdcAwareThreadPoolExecutor(int corePoolSize,
                                     int maximumPoolSize,
                                     long keepAliveTime,
                                     TimeUnit unit,
                                     BlockingQueue<Runnable> workQueue,
                                     ThreadFactory threadFactory,
                                     RejectedExecutionHandler handler) {
      super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
   }

   @Override
   protected void afterExecute(Runnable r, Throwable t) {
      System.out.println("Cleaning the MDC context");
      MDC.clear();
      org.apache.log4j.MDC.clear();
      ThreadContext.clearAll();
   }
}