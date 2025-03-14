package cn.tuyucheng.taketoday.dependencyinjectiontypes;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

public class DependencyInjectionIntegrationTest {

   @Test
   public void givenAutowiredAnnotation_WhenSetOnSetter_ThenDependencyValid() {
      ApplicationContext context = new ClassPathXmlApplicationContext("dependencyinjectiontypes-context.xml");
      ArticleWithSetterInjection article = (ArticleWithSetterInjection) context.getBean("articleWithSetterInjectionBean");

      String originalText = "This is a text !";
      String formattedArticle = article.format(originalText);

      assertTrue(originalText.toUpperCase().equals(formattedArticle));
   }

   @Test
   public void givenAutowiredAnnotation_WhenSetOnConstructor_ThenDependencyValid() {
      ApplicationContext context = new ClassPathXmlApplicationContext("dependencyinjectiontypes-context.xml");
      ArticleWithConstructorInjection article = (ArticleWithConstructorInjection) context.getBean("articleWithConstructorInjectionBean");

      String originalText = "This is a text !";
      String formattedArticle = article.format(originalText);

      assertTrue(originalText.toUpperCase().equals(formattedArticle));
   }
}