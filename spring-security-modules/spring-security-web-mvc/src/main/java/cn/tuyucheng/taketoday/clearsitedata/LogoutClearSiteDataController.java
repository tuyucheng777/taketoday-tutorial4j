package cn.tuyucheng.taketoday.clearsitedata;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LogoutClearSiteDataController {

   @GetMapping(value = "/taketoday/logout")
   public ResponseEntity<String> logout(@PathVariable String name) {
      return ResponseEntity.ok().build();
   }
}