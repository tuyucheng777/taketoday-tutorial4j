package cn.tuyucheng.taketoday.beanfactorypostprocessor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {PropertiesWithBeanFactoryPostProcessor.class, PropertiesWithBeanFactoryPostProcessorConfig.class})
public class PropertiesWithBeanFactoryPostProcessorUnitTest {

   @Autowired
   private String tutorialTitleFromComponentAnnotation;
   @Autowired
   private String tutorialTitleFromBeanAnnotation;

   @Test
   void givenBeanFactoryPostProcessor_whenCreatedWithBeanAnnotation_thenPropertiesAreRead() {
      assertThat(tutorialTitleFromBeanAnnotation).isEqualTo("Taketoday: Properties in BeanFactoryPostProcessor");
   }

   @Test
   void givenBeanFactoryPostProcessor_whenCreatedWithComponentAnnotation_thenPropertiesAreRead() {
      assertThat(tutorialTitleFromComponentAnnotation).isEqualTo("Taketoday - Properties in BeanFactoryPostProcessor");
   }
}