package cn.tuyucheng.taketoday.queryparamdoc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

   @SuppressWarnings("unused")
   public List<Book> getBooks(Integer page) {
      return new ArrayList<>();
   }
}