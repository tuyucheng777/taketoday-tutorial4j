package cn.tuyucheng.taketoday.concurrentrequest;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Thread.currentThread;
import static java.util.Arrays.asList;

@Service
public class ProductService {

   private final static List<Product> productRepository = asList(
         new Product(1, "Product 1", new Stock(100)),
         new Product(2, "Product 2", new Stock(50))
   );

   public Optional<Product> getProductById(int id) {
      Optional<Product> product = productRepository.stream()
            .filter(p -> p.getId() == id)
            .findFirst();
      String productName = product.map(Product::getName)
            .orElse(null);

      System.out.printf("Thread: %s; bean instance: %s; product id: %s has the name: %s%n", currentThread().getName(), this, id, productName);

      return product;
   }
}