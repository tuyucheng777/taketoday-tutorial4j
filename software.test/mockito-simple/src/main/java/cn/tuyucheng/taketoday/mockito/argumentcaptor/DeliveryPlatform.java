package cn.tuyucheng.taketoday.mockito.argumentcaptor;

public interface DeliveryPlatform {

   void deliver(Email email);

   String getServiceStatus();

   AuthenticationStatus authenticate(Credentials credentials);
}
