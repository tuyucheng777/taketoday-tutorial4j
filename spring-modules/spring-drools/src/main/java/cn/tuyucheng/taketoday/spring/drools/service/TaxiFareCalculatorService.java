package cn.tuyucheng.taketoday.spring.drools.service;

import cn.tuyucheng.taketoday.spring.drools.model.Fare;
import cn.tuyucheng.taketoday.spring.drools.model.TaxiRide;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxiFareCalculatorService {

   private static final Logger LOGGER = LoggerFactory.getLogger(TaxiFareCalculatorService.class);

   @Autowired
   private KieContainer kContainer;

   public Long calculateFare(TaxiRide taxiRide, Fare rideFare) {
      KieSession kieSession = kContainer.newKieSession();
      kieSession.setGlobal("rideFare", rideFare);
      kieSession.insert(taxiRide);
      kieSession.fireAllRules();
      kieSession.dispose();
      LOGGER.debug("!! RIDE FARE !! " + rideFare.getTotalFare());
      return rideFare.getTotalFare();
   }
}