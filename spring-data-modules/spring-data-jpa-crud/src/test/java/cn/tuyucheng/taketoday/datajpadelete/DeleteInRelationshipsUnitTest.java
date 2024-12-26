package cn.tuyucheng.taketoday.datajpadelete;

import cn.tuyucheng.taketoday.Application;
import cn.tuyucheng.taketoday.datajpadelete.entity.Book;
import cn.tuyucheng.taketoday.datajpadelete.entity.Category;
import cn.tuyucheng.taketoday.datajpadelete.repository.BookRepository;
import cn.tuyucheng.taketoday.datajpadelete.repository.CategoryRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class DeleteInRelationshipsUnitTest {

   @Autowired
   private BookRepository bookRepository;

   @Autowired
   private CategoryRepository categoryRepository;

   @Before
   public void setup() {
      Book book1 = new Book("The Hobbit");
      Category category1 = new Category("Cat1", book1);
      categoryRepository.save(category1);

      Book book2 = new Book("All Quiet on the Western Front");
      Category category2 = new Category("Cat2", book2);
      categoryRepository.save(category2);
   }

   @After
   public void teardown() {
      bookRepository.deleteAll();
      categoryRepository.deleteAll();
   }

   @Test
   public void whenDeletingCategories_thenBooksShouldAlsoBeDeleted() {
      categoryRepository.deleteAll();

      assertThat(bookRepository.count()).isEqualTo(0);
      assertThat(categoryRepository.count()).isEqualTo(0);
   }

   @Test
   public void whenDeletingBooks_thenCategoriesShouldAlsoBeDeleted() {
      bookRepository.deleteAll();

      assertThat(bookRepository.count()).isEqualTo(0);
      assertThat(categoryRepository.count()).isEqualTo(2);
   }
}