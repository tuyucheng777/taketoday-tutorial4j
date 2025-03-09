package cn.tuyucheng.taketoday.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import cn.tuyucheng.taketoday.hibernate.entities.Department;
import cn.tuyucheng.taketoday.hibernate.pessimisticlocking.Address;
import cn.tuyucheng.taketoday.hibernate.pessimisticlocking.Customer;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import cn.tuyucheng.taketoday.hibernate.entities.DeptEmployee;
import cn.tuyucheng.taketoday.hibernate.optimisticlocking.OptimisticLockingCourse;
import cn.tuyucheng.taketoday.hibernate.optimisticlocking.OptimisticLockingStudent;
import cn.tuyucheng.taketoday.hibernate.pessimisticlocking.Individual;
import cn.tuyucheng.taketoday.hibernate.pessimisticlocking.PessimisticLockingCourse;
import cn.tuyucheng.taketoday.hibernate.pessimisticlocking.PessimisticLockingEmployee;
import cn.tuyucheng.taketoday.hibernate.pessimisticlocking.PessimisticLockingStudent;
import cn.tuyucheng.taketoday.hibernate.pojo.Person;
import cn.tuyucheng.taketoday.hibernate.pojo.Post;
import cn.tuyucheng.taketoday.hibernate.pojo.Student;

public class HibernateUtil {
   private static String PROPERTY_FILE_NAME;

   public static SessionFactory getSessionFactory() throws IOException {
      return getSessionFactory(null);
   }

   public static SessionFactory getSessionFactory(String propertyFileName) throws IOException {
      PROPERTY_FILE_NAME = propertyFileName;
      ServiceRegistry serviceRegistry = configureServiceRegistry();
      return makeSessionFactory(serviceRegistry);
   }

   public static SessionFactory getSessionFactoryByProperties(Properties properties) throws IOException {
      ServiceRegistry serviceRegistry = configureServiceRegistry(properties);
      return makeSessionFactory(serviceRegistry);
   }

   private static SessionFactory makeSessionFactory(ServiceRegistry serviceRegistry) {
      MetadataSources metadataSources = new MetadataSources(serviceRegistry);

      metadataSources.addPackage("cn.tuyucheng.taketoday.hibernate.pojo");
      metadataSources.addAnnotatedClass(Person.class);
      metadataSources.addAnnotatedClass(Student.class);
      metadataSources.addAnnotatedClass(Individual.class);
      metadataSources.addAnnotatedClass(PessimisticLockingEmployee.class);
      metadataSources.addAnnotatedClass(PessimisticLockingStudent.class);
      metadataSources.addAnnotatedClass(PessimisticLockingCourse.class);
      metadataSources.addAnnotatedClass(Customer.class);
      metadataSources.addAnnotatedClass(Address.class);
      metadataSources.addAnnotatedClass(DeptEmployee.class);
      metadataSources.addAnnotatedClass(Department.class);
      metadataSources.addAnnotatedClass(OptimisticLockingCourse.class);
      metadataSources.addAnnotatedClass(OptimisticLockingStudent.class);
      metadataSources.addAnnotatedClass(Post.class);

      Metadata metadata = metadataSources.getMetadataBuilder()
            .build();

      return metadata.getSessionFactoryBuilder()
            .build();

   }

   private static ServiceRegistry configureServiceRegistry() throws IOException {
      return configureServiceRegistry(getProperties());
   }

   private static ServiceRegistry configureServiceRegistry(Properties properties) throws IOException {
      return new StandardServiceRegistryBuilder().applySettings(properties)
            .build();
   }

   public static Properties getProperties() throws IOException {
      Properties properties = new Properties();
      URL propertiesURL = Thread.currentThread()
            .getContextClassLoader()
            .getResource(StringUtils.defaultString(PROPERTY_FILE_NAME, "hibernate.properties"));
      try (FileInputStream inputStream = new FileInputStream(propertiesURL.getFile())) {
         properties.load(inputStream);
      }
      return properties;
   }
}