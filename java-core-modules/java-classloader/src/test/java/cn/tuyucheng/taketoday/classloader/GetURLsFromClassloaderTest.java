package cn.tuyucheng.taketoday.classloader;

import cn.tuyucheng.taketoday.classloader.internal.BasicClasspathResolver;
import cn.tuyucheng.taketoday.classloader.internal.InternalClasspathResolver;
import cn.tuyucheng.taketoday.classloader.internal.InternalJdkSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URLClassLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GetURLsFromClassloaderTest {

   final Logger log = LoggerFactory.getLogger(getClass());

   @Test
   void givenApplicationClassLoader_whenInspectingBasicResolver_thenURLsCannotBeDetermined() {
      var loader = getClass().getClassLoader();

      Assumptions.assumeFalse(loader instanceof URLClassLoader);

      var resolver = new BasicClasspathResolver();

      var classpath = resolver.getFullClasspath(loader);

      Assertions.assertTrue(classpath.isEmpty());
   }

   @Test
   void givenApplicationClassLoader_whenInspectingInternalResolver_thenURLsCanBeDetermined() {
      Assumptions.assumeTrue(InternalJdkSupport.available());

      var resolver = new InternalClasspathResolver();
      var loader = getClass().getClassLoader();

      Assumptions.assumeFalse(loader instanceof URLClassLoader);

      var classpath = resolver.getFullClasspath(loader);

      assertFalse(classpath.isEmpty());
   }

   @Test
   void givenCustomClassLoader_whenInspectingInternalResolver_thenURLsCanBeDetermined() throws MalformedURLException {
      var url = URI.create("https://repo1.maven.org/maven2/com/google/code/findbugs/jsr305/3.0.2/jsr305-3.0.2.jar")
            .toURL();

      try (var loader = new CustomClassLoader(url)) {
         Class<?> nonNull = loader.loadClass(javax.annotation.Nonnull.class.getName());

         Assertions.assertNotSame(Nonnull.class, nonNull);

         var resolver = new InternalClasspathResolver();

         var classpath = resolver.getFullClasspath(loader);

         assertEquals(1, classpath.size());

         Assertions.assertTrue(classpath.contains(url));
      } catch (IOException | ClassNotFoundException e) {
         log.warn("Download of {} failed", url);
         log.warn(e.getMessage(), e);
      }
   }
}