package cn.tuyucheng.taketoday.boot.collection.name.dao;

import cn.tuyucheng.taketoday.boot.collection.name.data.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String> {

}
