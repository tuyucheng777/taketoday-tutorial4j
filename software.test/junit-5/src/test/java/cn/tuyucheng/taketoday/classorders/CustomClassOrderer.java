package cn.tuyucheng.taketoday.classorders;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.ClassOrdererContext;

import java.util.Comparator;

public class CustomClassOrderer implements ClassOrderer {
   @Override
   public void orderClasses(ClassOrdererContext context) {
      context.getClassDescriptors().sort(
            Comparator.comparingInt(descriptor ->
                  descriptor.getTestClass().getSimpleName().length()
            )
      );
   }
}