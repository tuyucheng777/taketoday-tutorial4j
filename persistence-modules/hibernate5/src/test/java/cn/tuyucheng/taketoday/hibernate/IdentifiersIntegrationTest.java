package cn.tuyucheng.taketoday.hibernate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.hibernate.Transaction;

import java.io.IOException;

import org.hibernate.Session;

import static org.assertj.core.api.Assertions.assertThat;

import cn.tuyucheng.taketoday.hibernate.pojo.Product;
import cn.tuyucheng.taketoday.hibernate.pojo.Course;
import cn.tuyucheng.taketoday.hibernate.pojo.OrderEntry;
import cn.tuyucheng.taketoday.hibernate.pojo.OrderEntryIdClass;
import cn.tuyucheng.taketoday.hibernate.pojo.OrderEntryPK;
import cn.tuyucheng.taketoday.hibernate.pojo.Student;
import cn.tuyucheng.taketoday.hibernate.pojo.User;
import cn.tuyucheng.taketoday.hibernate.pojo.UserProfile;

public class IdentifiersIntegrationTest {
   private Session session;

   private Transaction transaction;

   @Before
   public void setUp() throws IOException {
      session = HibernateUtil.getSessionFactory()
            .openSession();
      transaction = session.beginTransaction();
   }

   @After
   public void tearDown() {
      transaction.rollback();
      session.close();
   }

   @Test
   public void whenSaveSimpleIdEntities_thenOk() {
      Student student = new Student();
      session.save(student);
      User user = new User();
      session.save(user);

      assertThat(student.getStudentId()).isEqualTo(1L);
      assertThat(user.getUserId()).isEqualTo(4L);

      Course course = new Course();
      session.save(course);

   }

   @Test
   public void whenSaveCustomGeneratedId_thenOk() {
      Product product = new Product();
      session.save(product);
      Product product2 = new Product();
      session.save(product2);

      assertThat(product2.getProdId()).isEqualTo("prod-2");
   }

   @Test
   public void whenSaveCompositeIdEntity_thenOk() {
      User user = new User();

      OrderEntryPK entryPK = new OrderEntryPK();
      entryPK.setOrderId(1L);
      entryPK.setProductId(30L);
      entryPK.setUser(user);

      OrderEntry entry = new OrderEntry();
      entry.setEntryId(entryPK);
      session.save(entry);

      assertThat(entry.getEntryId()
            .getOrderId()).isEqualTo(1L);
   }

   @Test
   public void whenSaveIdClassEntity_thenOk() {
      User user = new User();

      OrderEntryIdClass entry = new OrderEntryIdClass();
      entry.setOrderId(1L);
      entry.setProductId(30L);
      entry.setUser(user);
      session.save(entry);

      assertThat(entry.getOrderId()).isEqualTo(1L);
   }

   @Test
   public void whenSaveDerivedIdEntity_thenOk() {
      User user = new User();
      session.save(user);

      UserProfile profile = new UserProfile();
      profile.setUser(user);
      session.save(profile);

      assertThat(profile.getProfileId()).isEqualTo(user.getUserId());
   }

}
