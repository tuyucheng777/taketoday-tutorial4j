package cn.tuyucheng.taketoday.spring.data.jpa.queryjsonb;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {

   private final String key;
   private final String value;

   public ProductSpecification(String key, String value) {
      this.key = key;
      this.value = value;
   }

   @Override
   public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
      return cb.equal(cb.function("jsonb_extract_path_text", String.class, root.get("attributes"), cb.literal(key)), value);
   }
}