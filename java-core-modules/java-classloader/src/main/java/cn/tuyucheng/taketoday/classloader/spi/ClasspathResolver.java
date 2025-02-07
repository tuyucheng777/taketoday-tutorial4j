package cn.tuyucheng.taketoday.classloader.spi;

import cn.tuyucheng.taketoday.classloader.internal.BasicClasspathResolver;
import cn.tuyucheng.taketoday.classloader.internal.InternalClasspathResolver;
import cn.tuyucheng.taketoday.classloader.internal.InternalJdkSupport;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public interface ClasspathResolver {

   static ClasspathResolver get() {
      return InternalJdkSupport.available() ? new InternalClasspathResolver() : new BasicClasspathResolver();
   }

   void collectClasspath(ClassLoader loader, Set<URL> result);

   default Set<URL> getClasspath(ClassLoader loader) {
      var result = new HashSet<URL>();
      collectClasspath(loader, result);
      return result;
   }

   default Set<URL> getFullClasspath(ClassLoader loader) {
      var result = new HashSet<URL>();
      collectClasspath(loader, result);
      loader = loader.getParent();

      while (loader != null) {
         collectClasspath(loader, result);
         loader = loader.getParent();
      }
      return result;
   }
}