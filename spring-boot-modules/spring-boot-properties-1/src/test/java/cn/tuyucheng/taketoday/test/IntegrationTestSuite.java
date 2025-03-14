package cn.tuyucheng.taketoday.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cn.tuyucheng.taketoday.properties.basic.ExtendedPropertiesWithJavaIntegrationTest;
import cn.tuyucheng.taketoday.properties.external.ExternalPropertiesWithJavaIntegrationTest;

@RunWith(Suite.class)
@SuiteClasses({ //@formatter:off
    ExternalPropertiesWithJavaIntegrationTest.class,
    ExtendedPropertiesWithJavaIntegrationTest.class,
})// @formatter:on
public final class IntegrationTestSuite {
   //
}