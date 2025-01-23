package cn.tuyucheng.taketoday.azure.functions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.tuyucheng.taketoday.azure.functions")
public class AzureSpringCloudFunctionApplication {
   public static void main(String[] args) {
      SpringApplication.run(AzureSpringCloudFunctionApplication.class, args);
   }
}