package cn.tuyucheng.taketoday.apache.avro.util;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

public class AvroSchemaBuilder {

   public Schema createAvroHttpRequestSchema() {

      Schema clientIdentifier = SchemaBuilder.record("ClientIdentifier").namespace("cn.tuyucheng.taketoday.avro.model")
            .fields().requiredString("hostName").requiredString("ipAddress").endRecord();

      return SchemaBuilder.record("AvroHttpRequest").namespace("cn.tuyucheng.taketoday.avro.model").fields()
            .requiredLong("requestTime")
            .name("clientIdentifier").type(clientIdentifier).noDefault()
            .name("employeeNames").type().array().items().stringType().arrayDefault(null)
            .name("active").type().enumeration("Active").symbols("YES", "NO").noDefault()
            .endRecord();
   }
}