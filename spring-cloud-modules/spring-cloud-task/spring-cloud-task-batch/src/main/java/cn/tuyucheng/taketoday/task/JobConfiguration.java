package cn.tuyucheng.taketoday.task;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;
import java.util.logging.Logger;

@Configuration
public class JobConfiguration {

   private final static Logger LOGGER = Logger.getLogger(JobConfiguration.class.getName());

   @Autowired
   private PlatformTransactionManager transactionManager;

   @Autowired
   private JobRepository jobRepository;

   @Bean
   public Job job1(Step step1, Step step2) {
      return new JobBuilder("job1", jobRepository).incrementer(new RunIdIncrementer())
            .start(step1)
            .next(step2)
            .build();
   }

   @Bean
   public Step step1() {
      return new StepBuilder("job1step1", jobRepository).tasklet((contribution, chunkContext) -> {
         LOGGER.info("Tasklet has run");
         return RepeatStatus.FINISHED;
      }, transactionManager)
            .build();
   }

   @Bean
   public Step step2() {
      return new StepBuilder("job1step2", jobRepository).<String, String>chunk(3, transactionManager)
            .reader(new ListItemReader<>(Arrays.asList("7", "2", "3", "10", "5", "6")))
            .processor(item -> {
               LOGGER.info("Processing of chunks");
               return String.valueOf(Integer.parseInt(item) * -1);
            })
            .writer(items -> {
               for (String item : items) {
                  LOGGER.info(">> " + item);
               }
            })
            .build();
   }

   @Bean
   public Job job2(Step job2step1) {
      return new JobBuilder("job2", jobRepository).incrementer(new RunIdIncrementer())
            .start(job2step1)
            .build();
   }

   @Bean
   public Step job2step1() {
      return new StepBuilder("job2step1", jobRepository).tasklet((contribution, chunkContext) -> {
         LOGGER.info("This job is from Taketoday");
         return RepeatStatus.FINISHED;
      }, transactionManager)
            .build();
   }
}