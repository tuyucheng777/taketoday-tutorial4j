package cn.tuyucheng.taketoday.springvaultk8s;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;

import java.util.List;

@SpringBootApplication
public class VaultK8SApplication {

   public static void main(String... args) {
      SpringApplication.run(VaultK8SApplication.class, args);
   }

   @Bean
   CommandLineRunner listSecrets(VaultTemplate vault) {
      return args -> {
         VaultKeyValueOperations ops = vault.opsForKeyValue("secrets", VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);
         List<String> secrets = ops.list("");
         if (secrets == null) {
            System.out.println("No secrets found");
            return;
         }

         secrets.forEach(s -> {
            System.out.println("secret=" + s);
            var response = ops.get(s);
            var data = response.getRequiredData();

            data.entrySet()
                  .forEach(e -> {
                     System.out.println("- key=" + e.getKey() + " => " + e.getValue());
                  });
         });
      };
   }
}