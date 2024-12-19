package cn.tuyucheng.taketoday.loginextrafieldssimple;

public interface UserRepository {

   User findUser(String username, String domain);
}