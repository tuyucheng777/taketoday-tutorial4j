package cn.tuyucheng.taketoday.hibernate.joinfetchcriteriaquery.util;

import cn.tuyucheng.taketoday.hibernate.joinfetchcriteriaquery.model.League;
import cn.tuyucheng.taketoday.hibernate.joinfetchcriteriaquery.model.Player;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

   public static SessionFactory getHibernateSessionFactory() {

      Configuration configuration = new Configuration().configure();
      configuration.addAnnotatedClass(League.class);
      configuration.addAnnotatedClass(Player.class);
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

      SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

      return sessionFactory;
   }
}
