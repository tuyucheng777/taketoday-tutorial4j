package cn.tuyucheng.taketoday.spring.data.solr.repository;

import cn.tuyucheng.taketoday.spring.data.solr.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends SolrCrudRepository<Product, String> {

   Optional<Product> findById(String id);

   List<Product> findByName(String name);

   @Query("id:*?0* OR name:*?0*")
   Page<Product> findByCustomQuery(String searchTerm, Pageable pageable);

   @Query(name = "Product.findByNamedQuery")
   Page<Product> findByNamedQuery(String searchTerm, Pageable pageable);
}