package cn.tuyucheng.taketoday.loginextrafieldscustom;

public interface UserRepository {

   User findUser(String username, String domain);
}