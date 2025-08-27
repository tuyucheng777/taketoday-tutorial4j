package cn.tuyucheng.taketoday.recovery.config;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class SampleJob implements Job {
   @Override
   public void execute(JobExecutionContext context) {
      System.out.println("Executing SampleJob at " + System.currentTimeMillis());
   }
}