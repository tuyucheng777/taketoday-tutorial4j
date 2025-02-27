package cn.tuyucheng.taketoday.rxjava.operator;

import rx.Observable.Operator;
import rx.Subscriber;

public class ToCleanString implements Operator<String, String> {

   public static ToCleanString toCleanString() {
      return new ToCleanString();
   }

   private ToCleanString() {
      super();
   }

   @Override
   public Subscriber<? super String> call(final Subscriber<? super String> subscriber) {
      return new Subscriber<>(subscriber) {
         @Override
         public void onCompleted() {
            if (!subscriber.isUnsubscribed()) {
               subscriber.onCompleted();
            }
         }

         @Override
         public void onError(Throwable t) {
            if (!subscriber.isUnsubscribed()) {
               subscriber.onError(t);
            }
         }

         @Override
         public void onNext(String item) {
            if (!subscriber.isUnsubscribed()) {
               final String result = item.replaceAll("[^A-Za-z0-9]", "");
               subscriber.onNext(result);
            }
         }
      };
   }
}