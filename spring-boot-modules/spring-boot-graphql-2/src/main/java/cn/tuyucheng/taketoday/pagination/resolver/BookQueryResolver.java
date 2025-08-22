package cn.tuyucheng.taketoday.pagination.resolver;

import cn.tuyucheng.taketoday.pagination.dto.BookConnection;
import cn.tuyucheng.taketoday.pagination.dto.BookEdge;
import cn.tuyucheng.taketoday.pagination.dto.BookPage;
import cn.tuyucheng.taketoday.pagination.dto.PageInfo;
import cn.tuyucheng.taketoday.pagination.entity.Book;
import cn.tuyucheng.taketoday.pagination.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class BookQueryResolver {
   private final BookRepository bookRepository;

   public BookQueryResolver(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
   }

   @QueryMapping
   public BookPage books(@Argument int page, @Argument int size) {
      Pageable pageable = PageRequest.of(page, size);
      Page<Book> bookPage = bookRepository.findAll(pageable);
      return new BookPage(bookPage);
   }

   @QueryMapping
   public BookConnection booksByCursor(@Argument Optional<Long> cursor, @Argument int limit) {
      List<Book> books;

      if (cursor.isPresent()) {
         books = bookRepository.findByIdGreaterThanOrderByIdAsc(cursor.get(), PageRequest.of(0, limit));
      } else {
         books = bookRepository.findAllByOrderByIdAsc(PageRequest.of(0, limit));
      }

      List<BookEdge> edges = books.stream()
            .map(book -> new BookEdge(book, book.getId().toString()))
            .collect(Collectors.toList());
      String endCursor = books.isEmpty() ? null : books.get(books.size() - 1).getId().toString();
      boolean hasNextPage = !books.isEmpty() && bookRepository.existsByIdGreaterThan(books.get(books.size() - 1).getId());

      PageInfo pageInfo = new PageInfo(hasNextPage, endCursor);

      return new BookConnection(edges, pageInfo);
   }
}