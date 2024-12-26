package cn.tuyucheng.taketoday.jpa.paginationsorting.repository;

import cn.tuyucheng.taketoday.jpa.paginationsorting.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>, CrudRepository<Product, Integer> {

   List<Product> findAllByPrice(double price, Pageable pageable);
}