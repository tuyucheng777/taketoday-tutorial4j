package cn.tuyucheng.taketoday.couchbase.mapreduce;

public interface CouchbaseKeyGenerator<T> {

   String generateKey(T t);
}
