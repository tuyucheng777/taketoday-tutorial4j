package cn.tuyucheng.taketoday.couchbase.async.person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;

@Configuration
@ComponentScan(basePackages = {"cn.tuyucheng.taketoday.couchbase.async.service", "cn.tuyucheng.taketoday.couchbase.n1ql"})
public class PersonCrudServiceIntegrationTestConfig {

   @Bean
   public Cluster cluster() {
      CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder()
            .connectTimeout(60000)
            .build();
      return CouchbaseCluster.create(env, "127.0.0.1");
   }

}
