package cn.tuyucheng.taketoday;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCount {

   private static final Pattern SPACE = Pattern.compile(" ");

   public static void main(String[] args) throws Exception {
      if (args.length < 1) {
         System.err.println("Usage: JavaWordCount <file>");
         System.exit(1);
      }
      SparkConf sparkConf = new SparkConf().setAppName("JavaWordCount")
            .setMaster("local");
      JavaSparkContext ctx = new JavaSparkContext(sparkConf);
      JavaRDD<String> lines = ctx.textFile(args[0], 1);

      JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(SPACE.split(s)).iterator());
      JavaPairRDD<String, Integer> wordAsTuple = words.mapToPair(word -> new Tuple2<>(word, 1));
      JavaPairRDD<String, Integer> wordWithCount = wordAsTuple.reduceByKey(Integer::sum);
      List<Tuple2<String, Integer>> output = wordWithCount.collect();
      for (Tuple2<?, ?> tuple : output) {
         System.out.println(tuple._1() + ": " + tuple._2());
      }
      ctx.stop();
   }
}