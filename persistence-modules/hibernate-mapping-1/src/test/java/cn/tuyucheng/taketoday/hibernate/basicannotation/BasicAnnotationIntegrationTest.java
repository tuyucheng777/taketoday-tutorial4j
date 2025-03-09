package cn.tuyucheng.taketoday.hibernate.basicannotation;

import java.io.IOException;

import jakarta.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.tuyucheng.taketoday.hibernate.HibernateUtil;
import cn.tuyucheng.taketoday.hibernate.Strategy;

public class BasicAnnotationIntegrationTest {

   private static SessionFactory sessionFactory;
   private Session session;
   private Transaction transaction;

   @BeforeClass
   public static void beforeTests() {
      sessionFactory = HibernateUtil.getSessionFactory(Strategy.MAP_KEY_COLUMN_BASED);
   }

   @Before
   public void setUp() throws IOException {
      session = sessionFactory.openSession();
      transaction = session.beginTransaction();
   }

   @After
   public void tearDown() {
      transaction.rollback();
      session.close();
   }

   @Test
   public void givenACourse_whenCourseNamePresent_shouldPersist() {
      Course course = new Course();
      course.setName("Computers");

      session.save(course);
      session.flush();
      session.clear();

   }

   @Test(expected = PersistenceException.class)
   public void givenACourse_whenCourseNameAbsent_shouldFail() {
      Course course = new Course();

      session.save(course);
      session.flush();
      session.clear();
   }
}
