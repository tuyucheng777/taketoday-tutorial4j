package cn.tuyucheng.taketoday.specifications.join;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Join;

public class AuthorSpecifications {

   public static Specification<Author> hasFirstNameLike(String name) {
      return (root, _, criteriaBuilder) -> criteriaBuilder.like(root.get("firstName"), "%" + name + "%");
   }

   public static Specification<Author> hasLastName(String name) {
      return (root, _, cb) -> cb.equal(root.<String>get("lastName"), name);
   }

   public static Specification<Author> hasBookWithTitle(String bookTitle) {
      return (root, _, criteriaBuilder) -> {
         Join<BookAuthorEntity, Author> authorsBook = root.join("bookAuthorEntities");
         return criteriaBuilder.equal(authorsBook.get("title"), bookTitle);
      };
   }
}