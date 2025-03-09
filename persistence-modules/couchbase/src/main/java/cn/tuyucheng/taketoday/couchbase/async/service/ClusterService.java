package cn.tuyucheng.taketoday.couchbase.async.service;

import com.couchbase.client.java.Bucket;

public interface ClusterService {

   Bucket openBucket(String name, String password);
}
