package cn.tuyucheng.taketoday.springbatch.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ParallelJobService {

   @Autowired
   private JobLauncher jobLauncher;

   @Autowired
   private Job jobOne;

   @Autowired
   private Job jobTwo;

   public void runJobsInParallel() {
      SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();

      taskExecutor.execute(() -> {
         try {
            jobLauncher.run(jobOne, new JobParametersBuilder().addString("ID", "Parallel 1")
                  .toJobParameters());
         } catch (Exception e) {
            e.printStackTrace();
         }
      });

      taskExecutor.execute(() -> {
         try {
            jobLauncher.run(jobTwo, new JobParametersBuilder().addString("ID", "Parallel 2")
                  .toJobParameters());
         } catch (Exception e) {
            e.printStackTrace();
         }
      });

      taskExecutor.close();
   }
}