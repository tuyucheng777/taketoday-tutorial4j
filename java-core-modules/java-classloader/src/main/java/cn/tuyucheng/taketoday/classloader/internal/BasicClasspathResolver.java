package cn.tuyucheng.taketoday.classloader.internal;

import cn.tuyucheng.taketoday.classloader.spi.ClasspathResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Set;

public class BasicClasspathResolver implements ClasspathResolver {

   final Logger log = LoggerFactory.getLogger(getClass());

   @Override
   public void collectClasspath(ClassLoader loader, Set<URL> result) {
      log.info("Collecting URLs from {}", loader);

      if (loader instanceof URLClassLoader ucl) {
         var urls = Arrays.asList(ucl.getURLs());

         log.info("{} has {} urls", loader, urls.size());

         result.addAll(urls);
      } else {
         log.info("Unsupported {}", loader);
      }
   }
}