package cn.tuyucheng.taketoday.boot.unique.field.dao;

import cn.tuyucheng.taketoday.boot.unique.field.data.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssetRepository extends MongoRepository<Asset, String> {
}