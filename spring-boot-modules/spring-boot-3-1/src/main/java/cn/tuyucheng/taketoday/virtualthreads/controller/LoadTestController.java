package cn.tuyucheng.taketoday.virtualthreads.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadTestController {

   private static final Logger LOG = LoggerFactory.getLogger(LoadTestController.class);

   @GetMapping
   public void doSomething() throws InterruptedException {
      LOG.info("hey, I'm doing something");
      Thread.sleep(1000);
   }

}
