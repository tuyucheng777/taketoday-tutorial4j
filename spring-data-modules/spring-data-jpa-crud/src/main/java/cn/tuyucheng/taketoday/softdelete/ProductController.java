package cn.tuyucheng.taketoday.softdelete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

   @Autowired
   private ProductService productService;

   @PostMapping
   public Product createOne(@RequestBody Product product) {
      return productService.create(product);
   }

   @DeleteMapping("/{id}")
   public void removeOne(@PathVariable("id") Long id) {
      productService.remove(id);
   }

   @GetMapping
   public Iterable<Product> findAll(@RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted) {
      return productService.findAll(isDeleted);
   }
}