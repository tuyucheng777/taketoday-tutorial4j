package cn.tuyucheng.taketoday.scrollapi.repository;

import cn.tuyucheng.taketoday.scrollapi.entity.BookReview;
import org.springframework.data.domain.KeysetScrollPosition;
import org.springframework.data.domain.OffsetScrollPosition;
import org.springframework.data.domain.Window;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookReview, Long> {

   Window<BookReview> findFirst5ByBookRating(String bookRating, OffsetScrollPosition position);

   Window<BookReview> findFirst5ByBookRating(String bookRating, KeysetScrollPosition position);
}
