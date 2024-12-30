package cn.tuyucheng.taketoday.sootup;

import org.junit.jupiter.api.Test;
import sootup.core.IdentifierFactory;
import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.model.SootClass;
import sootup.core.types.ClassType;
import sootup.java.bytecode.inputlocation.OTFCompileAnalysisInputLocation;
import sootup.java.core.JavaSootClass;
import sootup.java.core.views.JavaView;

import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ClassUnitTest {
   @Test
   void whenAnalyzingThisTestClass_thenWeCanGetASingleClass() {
      Path javaFile = Path.of("src/test/java/cn/tuyucheng/taketoday/sootup/ClassUnitTest.java");
      AnalysisInputLocation inputLocation = new OTFCompileAnalysisInputLocation(javaFile);

      JavaView view = new JavaView(inputLocation);

      IdentifierFactory identifierFactory = view.getIdentifierFactory();
      ClassType javaClass = identifierFactory.getClassType("cn.tuyucheng.taketoday.sootup.ClassUnitTest");

      Optional<JavaSootClass> sootClass = view.getClass(javaClass);
      assertTrue(sootClass.isPresent());

      JavaSootClass classUnitTest = sootClass.get();
      assertTrue(classUnitTest.isPublic());
      assertTrue(classUnitTest.isConcrete());
      assertFalse(classUnitTest.isFinal());
      assertFalse(classUnitTest.isEnum());
   }

   @Test
   void whenAnalyzingThisTestClass_thenWeCanGetTheSuperclass() {
      Path javaFile = Path.of("src/test/java/cn/tuyucheng/taketoday/sootup/ClassUnitTest.java");
      AnalysisInputLocation inputLocation = new OTFCompileAnalysisInputLocation(javaFile);

      JavaView view = new JavaView(inputLocation);

      IdentifierFactory identifierFactory = view.getIdentifierFactory();
      ClassType javaClass = identifierFactory.getClassType("cn.tuyucheng.taketoday.sootup.ClassUnitTest");

      SootClass sootClass = view.getClassOrThrow(javaClass);
      Optional<? extends ClassType> superclass = sootClass.getSuperclass();

      assertTrue(superclass.isPresent());
      assertEquals("java.lang.Object", superclass.get().getFullyQualifiedName());
   }

   @Test
   void whenAnalyzingThisTestClass_thenWeCanGetTheInterfaces() {
      Path javaFile = Path.of("src/test/java/cn/tuyucheng/taketoday/sootup/ClassUnitTest.java");
      AnalysisInputLocation inputLocation = new OTFCompileAnalysisInputLocation(javaFile);

      JavaView view = new JavaView(inputLocation);

      IdentifierFactory identifierFactory = view.getIdentifierFactory();
      ClassType javaClass = identifierFactory.getClassType("cn.tuyucheng.taketoday.sootup.ClassUnitTest");

      SootClass sootClass = view.getClassOrThrow(javaClass);
      Set<? extends ClassType> interfaces = sootClass.getInterfaces();

      assertTrue(interfaces.isEmpty());
   }
}