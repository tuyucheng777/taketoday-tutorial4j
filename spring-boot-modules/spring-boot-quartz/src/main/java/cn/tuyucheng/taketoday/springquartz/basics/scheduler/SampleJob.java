package cn.tuyucheng.taketoday.springquartz.basics.scheduler;

import cn.tuyucheng.taketoday.springquartz.basics.service.SampleJobService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleJob implements Job {

   Logger logger = LoggerFactory.getLogger(getClass());

   @Autowired
   private SampleJobService jobService;

   public void execute(JobExecutionContext context) {
      logger.info("Job ** {} ** fired @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());

      jobService.executeSampleJob();

      logger.info("Next job scheduled @ {}", context.getNextFireTime());
   }
}
