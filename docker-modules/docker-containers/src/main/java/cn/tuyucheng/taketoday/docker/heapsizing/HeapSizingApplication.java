package cn.tuyucheng.taketoday.docker.heapsizing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

import static cn.tuyucheng.taketoday.docker.heapsizing.PrintXmxXms.logMemory;

@SpringBootApplication
public class HeapSizingApplication {
   private static final Logger logger = Logger.getLogger(HeapSizingApplication.class.getName());

   public static void main(String[] args) {
      SpringApplication.run(HeapSizingApplication.class, args);
      logMemory(logger);
   }
}