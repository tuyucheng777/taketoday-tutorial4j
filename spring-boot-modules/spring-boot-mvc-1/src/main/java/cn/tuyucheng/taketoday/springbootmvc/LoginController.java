package cn.tuyucheng.taketoday.springbootmvc;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tuyucheng.taketoday.springbootmvc.model.LoginForm;

@RestController
@RequestMapping("/")
public class LoginController {

   @PostMapping("loginform")
   public String processLogin(@Valid LoginForm form) {
      return "Success";
   }
}