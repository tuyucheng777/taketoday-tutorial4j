package cn.tuyucheng.taketoday.testsuite.suites;

import cn.tuyucheng.taketoday.testsuite.ClassOneUnitTest;
import cn.tuyucheng.taketoday.testsuite.subpackage.ClassTwoUnitTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
// import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

//@RunWith(JUnitPlatform.class)  Add junit-platform-runner dependency
@Suite
@SuiteDisplayName("My Test Suite")
@SelectClasses({ClassOneUnitTest.class, ClassTwoUnitTest.class})
public class JUnitRunWithSuite {
   // runs ClassOneUnitTest and ClassTwoUnitTest
   // equivalent to JUnitSelectClassesSuite
}