package cn.tuyucheng.taketoday.jdeffered;

import org.jdeferred.Deferred;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

class PromiseDemo {

   static void startJob(String jobName) {
      Deferred<String, String, String> deferred = new DeferredObject<>();
      Promise<String, String, String> promise = deferred.promise();

      promise.done(_ -> System.out.println("Job done")).fail(_ -> System.out.println("Job fail")).progress(_ -> System.out.println("Job is in progress")).always((_, _, _) -> System.out.println("Job execution started"));

      deferred.resolve(jobName);
      // deferred.notify("");
      // deferred.reject("oops");
   }
}