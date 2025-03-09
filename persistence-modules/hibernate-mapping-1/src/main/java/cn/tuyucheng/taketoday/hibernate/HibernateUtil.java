package cn.tuyucheng.taketoday.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import cn.tuyucheng.taketoday.hibernate.entities.Department;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import cn.tuyucheng.taketoday.hibernate.entities.DeptEmployee;
import cn.tuyucheng.taketoday.hibernate.pojo.Employee;
import cn.tuyucheng.taketoday.hibernate.pojo.EntityDescription;
import cn.tuyucheng.taketoday.hibernate.pojo.Phone;
import cn.tuyucheng.taketoday.hibernate.pojo.TemporalValues;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Animal;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Bag;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Book;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Car;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Laptop;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.MyEmployee;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.MyProduct;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Pen;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Pet;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Vehicle;

public class HibernateUtil {
   private static String PROPERTY_FILE_NAME;

   private HibernateUtil() {
   }

   public static SessionFactory getSessionFactory() throws IOException {
      return getSessionFactory("");
   }

   public static SessionFactory getSessionFactory(String propertyFileName) throws IOException {
      if (propertyFileName.equals("")) propertyFileName = null;
      PROPERTY_FILE_NAME = propertyFileName;
      ServiceRegistry serviceRegistry = configureServiceRegistry();
      return makeSessionFactory(serviceRegistry);
   }

   public static SessionFactory getSessionFactory(Strategy strategy) {
      return buildSessionFactory(strategy);
   }

   private static SessionFactory buildSessionFactory(Strategy strategy) {
      try {
         ServiceRegistry serviceRegistry = configureServiceRegistry();

         MetadataSources metadataSources = new MetadataSources(serviceRegistry);

         for (Class<?> entityClass : strategy.getEntityClasses()) {
            metadataSources.addAnnotatedClass(entityClass);
         }

         Metadata metadata = metadataSources.getMetadataBuilder()
               .build();

         return metadata.getSessionFactoryBuilder()
               .build();
      } catch (IOException ex) {
         throw new ExceptionInInitializerError(ex);
      }
   }

   private static SessionFactory makeSessionFactory(ServiceRegistry serviceRegistry) {
      MetadataSources metadataSources = new MetadataSources(serviceRegistry);

      metadataSources.addPackage("cn.tuyucheng.taketoday.hibernate.pojo");
      metadataSources.addAnnotatedClass(Employee.class);
      metadataSources.addAnnotatedClass(Phone.class);
      metadataSources.addAnnotatedClass(EntityDescription.class);
      metadataSources.addAnnotatedClass(TemporalValues.class);
      metadataSources.addAnnotatedClass(DeptEmployee.class);
      metadataSources.addAnnotatedClass(Department.class);
      metadataSources.addAnnotatedClass(Animal.class);
      metadataSources.addAnnotatedClass(Bag.class);
      metadataSources.addAnnotatedClass(Laptop.class);
      metadataSources.addAnnotatedClass(Book.class);
      metadataSources.addAnnotatedClass(Car.class);
      metadataSources.addAnnotatedClass(MyEmployee.class);
      metadataSources.addAnnotatedClass(MyProduct.class);
      metadataSources.addAnnotatedClass(Pen.class);
      metadataSources.addAnnotatedClass(Pet.class);
      metadataSources.addAnnotatedClass(Vehicle.class);

      Metadata metadata = metadataSources.getMetadataBuilder()
            .build();

      return metadata.getSessionFactoryBuilder()
            .build();

   }


   private static ServiceRegistry configureServiceRegistry() throws IOException {
      Properties properties = getProperties();
      return new StandardServiceRegistryBuilder().applySettings(properties)
            .build();
   }

   private static Properties getProperties() throws IOException {
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
