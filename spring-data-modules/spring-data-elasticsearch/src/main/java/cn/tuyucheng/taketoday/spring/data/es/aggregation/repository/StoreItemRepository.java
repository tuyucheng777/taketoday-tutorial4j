package cn.tuyucheng.taketoday.spring.data.es.aggregation.repository;

import cn.tuyucheng.taketoday.spring.data.es.aggregation.model.StoreItem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreItemRepository extends ElasticsearchRepository<StoreItem, String>,
      StoreItemRepositoryExtension {
}