package cn.tuyucheng.taketoday.securityconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

   @GetMapping(path = "/")
   public String home() {
      return "Hello";
   }

   @GetMapping(path = "/admin")
   public String admin() {
      return "ADMIN";
   }
}