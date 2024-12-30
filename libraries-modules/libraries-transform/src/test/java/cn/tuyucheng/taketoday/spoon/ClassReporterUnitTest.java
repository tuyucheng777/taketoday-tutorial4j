package cn.tuyucheng.taketoday.spoon;

import cn.tuyucheng.taketoday.spoon.ClassReporter.MethodSummary;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassReporterUnitTest {

   @Test
   public void givenBrokenClass_whenGenerateReport_thenSuccess() {
      ClassReporter reporter = new ClassReporter();
      MethodSummary report = reporter.generateMethodSummaryReport("src/test/resources/spoon/BrokenClass.java");

      assertThat(report).isNotNull();
      assertThat(report.getPrivateMethodCount()).isEqualTo(0);
      assertThat(report.getPublicMethodCount()).isEqualTo(1);
      assertThat(report.getProtectedMethodCount()).isEqualTo(1);
   }

   @Test
   public void whenGenerateReport_thenSuccess() {
      ClassReporter reporter = new ClassReporter();
      MethodSummary report = reporter.generateMethodSummaryReport("src/test/resources/spoon/SpoonClassToTest.java");
      assertThat(report).isNotNull();
      assertThat(report.getPackagePrivateMethodCount()).isEqualTo(1);
      assertThat(report.getPublicMethodCount()).isEqualTo(1);
      assertThat(report.getPrivateMethodCount()).isEqualTo(1);
   }
}