package cn.tuyucheng.taketoday.spring.data.es.aggregation.repository;

import cn.tuyucheng.taketoday.spring.data.es.aggregation.model.StoreItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchPage;

public interface StoreItemRepositoryExtension {
   SearchPage<StoreItem> findAllWithAggregations(Pageable pageable);
}