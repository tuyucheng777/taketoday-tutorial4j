package cn.tuyucheng.taketoday.spring.data.cosmosdb.controller;

import cn.tuyucheng.taketoday.spring.data.cosmosdb.entity.Product;
import cn.tuyucheng.taketoday.spring.data.cosmosdb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

   private ProductService productService;

   @Autowired
   public ProductController(ProductService productService) {
      this.productService = productService;
   }

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public void create(@RequestBody Product product) {
      productService.saveProduct(product);
   }

   @GetMapping(value = "/{id}/category/{category}")
   public Optional<Product> get(@PathVariable String id, @PathVariable String category) {
      return productService.findById(id, category);
   }

   @DeleteMapping(value = "/{id}/category/{category}")
   public void delete(@PathVariable String id, @PathVariable String category) {
      productService.delete(id, category);
   }

   @GetMapping
   public List<Product> getByName(@RequestParam String name) {
      return productService.findProductByName(name);
   }
}