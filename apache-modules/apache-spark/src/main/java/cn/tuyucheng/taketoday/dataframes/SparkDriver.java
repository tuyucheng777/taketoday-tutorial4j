package cn.tuyucheng.taketoday.dataframes;

import org.apache.spark.sql.SparkSession;

import java.io.Serializable;

public class SparkDriver implements Serializable {

   public static SparkSession getSparkSession() {
      return SparkSession.builder()
            .appName("Customer Aggregation pipeline")
            .config("spark.sql.legacy.timeParserPolicy", "LEGACY")
            .master("local")
            .getOrCreate();
   }
}