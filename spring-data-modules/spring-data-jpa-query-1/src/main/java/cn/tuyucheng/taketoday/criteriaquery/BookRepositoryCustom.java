package cn.tuyucheng.taketoday.criteriaquery;

import java.util.List;

interface BookRepositoryCustom {

   List<Book> findBooksByAuthorNameAndTitle(String authorName, String title);
}