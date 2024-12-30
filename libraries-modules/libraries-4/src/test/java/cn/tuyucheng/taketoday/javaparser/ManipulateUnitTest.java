package cn.tuyucheng.taketoday.javaparser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManipulateUnitTest {
   private final String code = String.join("\n", Arrays.asList(
         "package cn.tuyucheng.taketoday.javaparser;",
         "import java.util.List;",
         "class TestClass {",
         "private List<String> doSomething()  {}",
         "private class Inner {",
         "private String other() {}",
         "}",
         "}"
   ));

   @Test
   void capitalizeMethods() {
      CompilationUnit compilationUnit = StaticJavaParser.parse(code);

      compilationUnit.accept(new VoidVisitorAdapter<Object>() {
         @Override
         public void visit(MethodDeclaration n, Object arg) {
            super.visit(n, arg);

            n.setName(n.getName().asString().toUpperCase());
         }
      }, null);

      String formatted = compilationUnit.toString();
      assertEquals("""
            package cn.tuyucheng.taketoday.javaparser;

            import java.util.List;

            class TestClass {

                private List<String> DOSOMETHING() {
                }

                private class Inner {

                    private String OTHER() {
                    }
                }
            }
            """, formatted);
   }
}