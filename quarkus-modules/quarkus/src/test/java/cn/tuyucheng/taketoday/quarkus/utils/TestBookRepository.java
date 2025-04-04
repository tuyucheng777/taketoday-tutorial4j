package cn.tuyucheng.taketoday.quarkus.utils;

import cn.tuyucheng.taketoday.quarkus.model.Book;
import cn.tuyucheng.taketoday.quarkus.repository.BookRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@Priority(1)
@Alternative
@ApplicationScoped
public class TestBookRepository extends BookRepository {

   @PostConstruct
   public void init() {
      persist(new Book("Dune", "Frank Herbert"),
            new Book("Foundation", "Isaac Asimov"));
   }
}