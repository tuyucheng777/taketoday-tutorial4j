package cn.tuyucheng.taketoday.boot.unique.field.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.tuyucheng.taketoday.boot.unique.field.data.Sale;
import cn.tuyucheng.taketoday.boot.unique.field.data.SaleId;

public interface SaleRepository extends MongoRepository<Sale, String> {
    Optional<Sale> findBySaleId(SaleId id);
}
