package cn.tuyucheng.taketoday.sampleabstract;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BallService {

   private RuleRepository ruleRepository;

   private LogRepository logRepository;

   public BallService(RuleRepository ruleRepository) {
      this.ruleRepository = ruleRepository;
   }

   @Autowired
   public final void setLogRepository(LogRepository logRepository) {
      this.logRepository = logRepository;
   }

   @PostConstruct
   public void afterInitialize() {

      System.out.println(ruleRepository.toString());
      System.out.println(logRepository.toString());
   }
}