package cn.tuyucheng.taketoday.services;

import org.springframework.stereotype.Service;

import cn.tuyucheng.taketoday.requestresponsebody.LoginForm;

@Service
public class ExampleService {

   public boolean fakeAuthenticate(LoginForm lf) {
      return true;
   }
}