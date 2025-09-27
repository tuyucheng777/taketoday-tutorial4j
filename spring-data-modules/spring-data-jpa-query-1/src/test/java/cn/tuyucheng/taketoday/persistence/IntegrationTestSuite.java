package cn.tuyucheng.taketoday.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import cn.tuyucheng.taketoday.persistence.audit.AuditTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ // @formatter:off
    AuditTestSuite.class
}) // @formatter:on
public class IntegrationTestSuite {
   //
}