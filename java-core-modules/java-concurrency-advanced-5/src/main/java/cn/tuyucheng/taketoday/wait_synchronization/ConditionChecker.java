package cn.tuyucheng.taketoday.wait_synchronization;

public class ConditionChecker {

   private volatile boolean jobIsDone;
   private final Object lock = new Object();

   public void ensureCondition() {
      synchronized (lock) {
         while (!jobIsDone) {
            try {
               lock.wait();
            } catch (InterruptedException ignored) {
            }
         }
      }
   }

   public void complete() {
      synchronized (lock) {
         jobIsDone = true;
         lock.notify();
      }
   }
}