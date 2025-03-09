package cn.tuyucheng.taketoday.couchbase.async.person;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.tuyucheng.taketoday.couchbase.async.service.AbstractCrudService;
import cn.tuyucheng.taketoday.couchbase.async.service.BucketService;

@Service
public class PersonCrudService extends AbstractCrudService<Person> {

   @Autowired
   public PersonCrudService(@Qualifier("TutorialBucketService") BucketService bucketService, PersonDocumentConverter converter) {
      super(bucketService, converter);
   }

   @PostConstruct
   private void init() {
      loadBucket();
   }
}
