package cn.tuyucheng.taketoday.samples.endpoints;

public interface Activator<T> {

   void handleMessage(T input);
}