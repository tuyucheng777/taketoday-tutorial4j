package cn.tuyucheng.taketoday.beanshell.controller;

import cn.tuyucheng.taketoday.beanshell.model.Item;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Api {

   @PostMapping
   public String post(@RequestBody Item body) {
      return body.getId()
            .toString();
   }
}