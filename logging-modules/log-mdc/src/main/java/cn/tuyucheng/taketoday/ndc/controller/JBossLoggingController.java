package cn.tuyucheng.taketoday.ndc.controller;

import cn.tuyucheng.taketoday.ndc.Investment;
import cn.tuyucheng.taketoday.ndc.service.InvestmentService;
import org.jboss.logging.NDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JBossLoggingController {
   @Autowired
   @Qualifier("JBossLoggingInvestmentService")
   private InvestmentService jbossLoggingBusinessService;

   @RequestMapping(value = "/ndc/jboss-logging", method = RequestMethod.POST)
   public ResponseEntity<Investment> postPayment(@RequestBody Investment investment) {
      // Add transactionId and owner to NDC
      NDC.push("tx.id=" + investment.getTransactionId());
      NDC.push("tx.owner=" + investment.getOwner());

      try {
         jbossLoggingBusinessService.transfer(investment.getAmount());
      } finally {
         // take out owner from the NDC stack
         NDC.pop();

         // take out transactionId from the NDC stack
         NDC.pop();

         NDC.clear();
      }
      return new ResponseEntity<>(investment, HttpStatus.OK);
   }
}