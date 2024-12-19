package cn.tuyucheng.taketoday.jsonignore.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tuyucheng.taketoday.jsonignore.emptyfields.Employee;

@RestController
@RequestMapping(EmptyEmployeeEchoController.USERS)
public class EmptyEmployeeEchoController {

   public static final String USERS = "/empty_employees";

   @PostMapping
   public Employee echoUser(@RequestBody Employee employee) {
      return employee;
   }
}