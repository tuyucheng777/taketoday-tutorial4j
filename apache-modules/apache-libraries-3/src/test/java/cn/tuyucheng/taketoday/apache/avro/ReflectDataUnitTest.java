package cn.tuyucheng.taketoday.apache.avro;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

import org.apache.avro.Conversions;
import org.apache.avro.Schema;
import org.apache.avro.data.TimeConversions;
import org.apache.avro.reflect.ReflectData;
import org.junit.jupiter.api.Test;

import cn.tuyucheng.taketoday.apache.avro.model.BankAccountWithAbstractField;
import cn.tuyucheng.taketoday.apache.avro.model.BankAccountWithIgnoredField;
import cn.tuyucheng.taketoday.apache.avro.model.BankAccountWithLogicalTypes;
import cn.tuyucheng.taketoday.apache.avro.model.BankAccountWithNullableField;
import cn.tuyucheng.taketoday.apache.avro.model.BankAccountWithOverriddenField;
import cn.tuyucheng.taketoday.apache.avro.model.SimpleBankAccount;

class ReflectDataUnitTest {

   @Test
   void whenConvertingSimpleRecord_thenAvroSchemaIsCorrect() {
      Schema schema = ReflectData.get()
            .getSchema(SimpleBankAccount.class);
      String jsonSchema = schema.toString();

      assertThatJson(jsonSchema).isEqualTo("""
            {
              "type" : "record",
              "name" : "SimpleBankAccount",
              "namespace" : "cn.tuyucheng.taketoday.apache.avro.model",
              "fields" : [ {
                "name" : "bankAccountNumber",
                "type" : "string"
              } ]
            }
            """);
   }

   @Test
   void whenConvertingRecordWithNullableField_thenAvroSchemaIsCorrect() {
      Schema schema = ReflectData.get()
            .getSchema(BankAccountWithNullableField.class);
      String jsonSchema = schema.toString();

      assertThatJson(jsonSchema).isEqualTo("""
            {
              "type" : "record",
              "name" : "BankAccountWithNullableField",
              "namespace" : "cn.tuyucheng.taketoday.apache.avro.model",
              "fields" : [ {
                "name" : "bankAccountNumber",
                "type" : "string"
              }, {
                "name" : "reference",
                "type" : [ "null", "string" ],
                "default" : null
              } ]
            }
            """);
   }

   @Test
   void whenConvertingRecordWithIgnoredField_thenAvroSchemaIsCorrect() {
      Schema schema = ReflectData.get()
            .getSchema(BankAccountWithIgnoredField.class);
      String jsonSchema = schema.toString();

      assertThatJson(jsonSchema).isEqualTo("""
            {
              "type" : "record",
              "name" : "BankAccountWithIgnoredField",
              "namespace" : "cn.tuyucheng.taketoday.apache.avro.model",
              "fields" : [ {
                "name" : "bankAccountNumber",
                "type" : "string"
              } ]
            }
            """);
   }

   @Test
   void whenConvertingRecordWithOverriddenField_thenAvroSchemaIsCorrect() {
      Schema schema = ReflectData.get()
            .getSchema(BankAccountWithOverriddenField.class);
      String jsonSchema = schema.toString();

      assertThatJson(jsonSchema).isEqualTo("""
            {
              "type" : "record",
              "name" : "BankAccountWithOverriddenField",
              "namespace" : "cn.tuyucheng.taketoday.apache.avro.model",
              "fields" : [ {
                "name" : "bankAccountNumber",
                "type" : "string"
              }, {
                "name" : "bankAccountReference",
                "type" : "string"
              } ]
            }
            """);
   }

   @Test
   void whenConvertingRecordWithAbstractField_thenAvroSchemaIsCorrect() {
      Schema schema = ReflectData.get()
            .getSchema(BankAccountWithAbstractField.class);
      String jsonSchema = schema.toString();

      assertThatJson(jsonSchema).isEqualTo("""
            {
              "type" : "record",
              "name" : "BankAccountWithAbstractField",
              "namespace" : "cn.tuyucheng.taketoday.apache.avro.model",
              "fields" : [ {
                "name" : "bankAccountNumber",
                "type" : "string"
              }, {
                "name" : "reference",
                "type" : [ {
                  "type" : "record",
                  "name" : "PersonalBankAccountReference",
                  "namespace" : "cn.tuyucheng.taketoday.apache.avro.model.BankAccountWithAbstractField",
                  "fields" : [ {
                    "name" : "holderName",
                    "type" : "string"
                  }, {
                    "name" : "reference",
                    "type" : "string"
                  } ]
                }, {
                  "type" : "record",
                  "name" : "BusinessBankAccountReference",
                  "namespace" : "cn.tuyucheng.taketoday.apache.avro.model.BankAccountWithAbstractField",
                  "fields" : [ {
                    "name" : "businessEntityId",
                    "type" : "string"
                  }, {
                    "name" : "reference",
                    "type" : "string"
                  } ]
                } ]
              } ]
            }
            """);
   }

   @Test
   void whenConvertingRecordWithLogicalTypes_thenAvroSchemaIsCorrect() {
      ReflectData reflectData = ReflectData.get();
      reflectData.addLogicalTypeConversion(new Conversions.UUIDConversion());
      reflectData.addLogicalTypeConversion(new TimeConversions.LocalTimestampMillisConversion());

      String jsonSchema = reflectData.getSchema(BankAccountWithLogicalTypes.class)
            .toString();

      assertThatJson(jsonSchema).isEqualTo("""
            {
              "type" : "record",
              "name" : "BankAccountWithLogicalTypes",
              "namespace" : "cn.tuyucheng.taketoday.apache.avro.model",
              "fields" : [ {
                "name" : "bankAccountNumber",
                "type" : "string"
              }, {
                "name" : "expiryDate",
                "type" : {
                  "type" : "long",
                  "logicalType" : "local-timestamp-millis"
                }
              }, {
                "name" : "reference",
                "type" : {
                  "type" : "string",
                  "logicalType" : "uuid"
                }
              } ]
            }
            """);
   }
}