package cn.tuyucheng.taketoday.couchbase.async.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("TutorialBucketService")
public class TutorialBucketService extends AbstractBucketService {

   @PostConstruct
   void init() {
      openBucket();
   }

   @Autowired
   public TutorialBucketService(ClusterService clusterService) {
      super(clusterService);
      openBucket();
   }

   @Override
   protected String getBucketName() {
      return "taketoday-tutorial";
   }

   @Override
   protected String getBucketPassword() {
      return "";
   }
}
