package cn.tuyucheng.taketoday.junit5.repository;

import cn.tuyucheng.taketoday.junit5.User;

public interface MailClient {

   void sendUserRegistrationMail(User user);
}