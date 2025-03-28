package cn.tuyucheng.taketoday.wiring.configuration.autowired;

import cn.tuyucheng.taketoday.dependency.ArbitraryDependency;
import cn.tuyucheng.taketoday.wiring.configuration.ApplicationContextTestAutowiredName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
      loader = AnnotationConfigContextLoader.class,
      classes = ApplicationContextTestAutowiredName.class)
public class FieldAutowiredNameIntegrationTest {

   @Autowired
   private ArbitraryDependency autowiredFieldDependency;

   @Test
   public void givenAutowiredAnnotation_WhenOnField_ThenDependencyValid() {
      assertNotNull(autowiredFieldDependency);
      assertEquals("Arbitrary Dependency", autowiredFieldDependency.toString());
   }
}