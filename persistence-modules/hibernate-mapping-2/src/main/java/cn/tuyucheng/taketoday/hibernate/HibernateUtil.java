package cn.tuyucheng.taketoday.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.tuyucheng.taketoday.hibernate.booleanconverters.model.Question;
import cn.tuyucheng.taketoday.hibernate.manytomany.model.Employee;
import cn.tuyucheng.taketoday.hibernate.manytomany.model.Project;
import cn.tuyucheng.taketoday.hibernate.uuids.WebSiteUser;
import cn.tuyucheng.taketoday.hibernate.uuids.Element;
import cn.tuyucheng.taketoday.hibernate.uuids.Reservation;
import cn.tuyucheng.taketoday.hibernate.uuids.Sale;

public class HibernateUtil {

   private static final String DEFAULT_RESOURCE = "manytomany.cfg.xml";
   private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);

   private static SessionFactory buildSessionFactory(String resource) {
      try {
         // Create the SessionFactory from hibernate-annotation.cfg.xml
         Configuration configuration = new Configuration();
         configuration.addAnnotatedClass(Employee.class);
         configuration.addAnnotatedClass(Project.class);
         configuration.addAnnotatedClass(WebSiteUser.class);
         configuration.addAnnotatedClass(Element.class);
         configuration.addAnnotatedClass(Reservation.class);
         configuration.addAnnotatedClass(Sale.class);
         configuration.addAnnotatedClass(Question.class);
         configuration.addPackage(Question.class.getPackageName());
         configuration.configure(resource);
         LOGGER.debug("Hibernate Annotation Configuration loaded");

         ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
               .build();
         LOGGER.debug("Hibernate Annotation serviceRegistry created");

         return configuration.buildSessionFactory(serviceRegistry);
      } catch (Throwable ex) {
         LOGGER.error("Initial SessionFactory creation failed.", ex);
         throw new ExceptionInInitializerError(ex);
      }
   }

   public static SessionFactory getSessionFactory() {
      return buildSessionFactory(DEFAULT_RESOURCE);
   }

   public static SessionFactory getSessionFactory(String resource) {
      return buildSessionFactory(resource);
   }
}
