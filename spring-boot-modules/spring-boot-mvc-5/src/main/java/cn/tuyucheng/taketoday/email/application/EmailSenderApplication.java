package cn.tuyucheng.taketoday.email.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.tuyucheng.taketoday.email.service.EmailService;

@SpringBootApplication(scanBasePackages = {"cn.tuyucheng.taketoday.email.service"})
public class EmailSenderApplication implements CommandLineRunner {

   private final EmailService emailService;

   public EmailSenderApplication(EmailService emailService) {
      this.emailService = emailService;
   }

   public static void main(String[] args) {
      SpringApplication.run(EmailSenderApplication.class, args);
   }

   @Override
   public void run(String... args) {
      emailService.sendSimpleEmail("recipient@tuyucheng.com", "Test Subject", "Testing the Spring Boot Email!");
   }
}