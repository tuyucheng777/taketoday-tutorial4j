package cn.tuyucheng.taketoday.hibernate.multitenancy.schema;

import java.io.IOException;

import org.junit.Test;

import cn.tuyucheng.taketoday.hibernate.multitenancy.MultitenancyIntegrationTest;
import cn.tuyucheng.taketoday.hibernate.multitenancy.database.TenantIdNames;

public class SchemaApproachMultitenancyIntegrationTest extends MultitenancyIntegrationTest {

   @Override
   public String getPropertyFile() {
      return "/hibernate-schema-multitenancy.properties";
   }

   @Test
   public void givenSchemaApproach_whenAddingEntries_thenOnlyAddedToConcreteSchema() throws IOException {
      whenCurrentTenantIs(TenantIdNames.MYDB1);
      whenAddCar("Ferrari");
      thenCarFound("Ferrari");
      whenCurrentTenantIs(TenantIdNames.MYDB2);
      thenCarNotFound("Ferrari");
   }

}
