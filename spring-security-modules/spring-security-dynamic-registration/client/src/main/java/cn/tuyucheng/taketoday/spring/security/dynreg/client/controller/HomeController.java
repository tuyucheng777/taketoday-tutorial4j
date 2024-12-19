package cn.tuyucheng.taketoday.spring.security.dynreg.client.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   @GetMapping(path = {"/", "/index"})
   String index(Authentication user, Model model) {
      model.addAttribute("user", user);
      return "index";
   }
}