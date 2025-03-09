package cn.tuyucheng.taketoday.couchbase.mapreduce;

@SuppressWarnings("serial")
public class DuplicateKeyException extends Exception {

   public DuplicateKeyException(String s) {
      super(s);
   }

}
