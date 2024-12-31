package cn.tuyucheng.taketoday.reactor.convertlistoflux;

public interface Callback<T> {

   void onTrigger(T element);
}