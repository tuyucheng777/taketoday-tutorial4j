package cn.tuyucheng.taketoday.service;

import cn.tuyucheng.taketoday.entity.User;
import cn.tuyucheng.taketoday.entity.Product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import cn.tuyucheng.taketoday.repository.user.UserRepository;
import cn.tuyucheng.taketoday.repository.product.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MultiDbServiceLiveTest {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private ProductRepository productRepository;

   @Transactional("productTransactionManager")
   @Test
   void givenUsersAndProducts_whenSaved_thenFoundById() {
      User user = new User();
      user.setName("John");
      userRepository.save(user);

      Product product = new Product();
      product.setName("Laptop");
      productRepository.save(product);

      assertTrue(userRepository.findById(user.getId()).isPresent());
      assertTrue(productRepository.findById(product.getId()).isPresent());
   }
}