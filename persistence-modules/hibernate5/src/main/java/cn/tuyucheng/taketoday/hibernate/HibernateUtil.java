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
import cn.tuyucheng.taketoday.hibernate.pojo.Course;
import cn.tuyucheng.taketoday.hibernate.pojo.Employee;
import cn.tuyucheng.taketoday.hibernate.pojo.EntityDescription;
import cn.tuyucheng.taketoday.hibernate.pojo.OrderEntry;
import cn.tuyucheng.taketoday.hibernate.pojo.OrderEntryIdClass;
import cn.tuyucheng.taketoday.hibernate.pojo.OrderEntryPK;
import cn.tuyucheng.taketoday.hibernate.pojo.Phone;
import cn.tuyucheng.taketoday.hibernate.pojo.PointEntity;
import cn.tuyucheng.taketoday.hibernate.pojo.PolygonEntity;
import cn.tuyucheng.taketoday.hibernate.pojo.Post;
import cn.tuyucheng.taketoday.hibernate.pojo.Product;
import cn.tuyucheng.taketoday.hibernate.pojo.Student;
import cn.tuyucheng.taketoday.hibernate.pojo.TemporalValues;
import cn.tuyucheng.taketoday.hibernate.pojo.User;
import cn.tuyucheng.taketoday.hibernate.pojo.UserProfile;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Animal;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Bag;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Book;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Car;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.MyEmployee;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.MyProduct;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Pen;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Pet;
import cn.tuyucheng.taketoday.hibernate.pojo.inheritance.Vehicle;

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
      metadataSources.addAnnotatedClass(Employee.class);
      metadataSources.addAnnotatedClass(Phone.class);
      metadataSources.addAnnotatedClass(EntityDescription.class);
      metadataSources.addAnnotatedClass(TemporalValues.class);
      metadataSources.addAnnotatedClass(User.class);
      metadataSources.addAnnotatedClass(Student.class);
      metadataSources.addAnnotatedClass(Course.class);
      metadataSources.addAnnotatedClass(Product.class);
      metadataSources.addAnnotatedClass(OrderEntryPK.class);
      metadataSources.addAnnotatedClass(OrderEntry.class);
      metadataSources.addAnnotatedClass(OrderEntryIdClass.class);
      metadataSources.addAnnotatedClass(UserProfile.class);
      metadataSources.addAnnotatedClass(Book.class);
      metadataSources.addAnnotatedClass(MyEmployee.class);
      metadataSources.addAnnotatedClass(MyProduct.class);
      metadataSources.addAnnotatedClass(Pen.class);
      metadataSources.addAnnotatedClass(Animal.class);
      metadataSources.addAnnotatedClass(Pet.class);
      metadataSources.addAnnotatedClass(Vehicle.class);
      metadataSources.addAnnotatedClass(Car.class);
      metadataSources.addAnnotatedClass(Bag.class);
      metadataSources.addAnnotatedClass(PointEntity.class);
      metadataSources.addAnnotatedClass(PolygonEntity.class);
      metadataSources.addAnnotatedClass(DeptEmployee.class);
      metadataSources.addAnnotatedClass(Department.class);
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