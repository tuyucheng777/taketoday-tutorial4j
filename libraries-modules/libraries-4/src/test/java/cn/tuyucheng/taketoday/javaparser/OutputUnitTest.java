package cn.tuyucheng.taketoday.javaparser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.DefaultPrettyPrinterVisitor;
import com.github.javaparser.printer.configuration.DefaultConfigurationOption;
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;
import com.github.javaparser.printer.configuration.Indentation;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputUnitTest {
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
   void withToString() {
      CompilationUnit compilationUnit = StaticJavaParser.parse(code);

      String formatted = compilationUnit.toString();
      assertEquals("""
            package cn.tuyucheng.taketoday.javaparser;

            import java.util.List;

            class TestClass {

                private List<String> doSomething() {
                }

                private class Inner {

                    private String other() {
                    }
                }
            }
            """, formatted);
   }

   @Test
   void withVisitor() {
      CompilationUnit compilationUnit = StaticJavaParser.parse(code);

      DefaultPrinterConfiguration printerConfiguration = new DefaultPrinterConfiguration();
      printerConfiguration.addOption(new DefaultConfigurationOption(DefaultPrinterConfiguration.ConfigOption.INDENTATION,
            new Indentation(Indentation.IndentType.SPACES, 2)));
      DefaultPrettyPrinterVisitor visitor = new DefaultPrettyPrinterVisitor(printerConfiguration);

      compilationUnit.accept(visitor, null);
      String formatted = visitor.toString();

      assertEquals("""
            package cn.tuyucheng.taketoday.javaparser;

            import java.util.List;

            class TestClass {

              private List<String> doSomething() {
              }

              private class Inner {

                private String other() {
                }
              }
            }
            """, formatted);
   }
}