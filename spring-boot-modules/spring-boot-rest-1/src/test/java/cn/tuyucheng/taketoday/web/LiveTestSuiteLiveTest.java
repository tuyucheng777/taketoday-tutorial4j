package cn.tuyucheng.taketoday.web;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
      FooDiscoverabilityLiveTest.class,
      FooLiveTest.class,
      FooPageableLiveTest.class
})
public class LiveTestSuiteLiveTest {
}