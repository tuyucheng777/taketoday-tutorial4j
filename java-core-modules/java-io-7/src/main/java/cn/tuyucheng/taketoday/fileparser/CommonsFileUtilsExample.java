package cn.tuyucheng.taketoday.fileparser;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommonsFileUtilsExample {

   static ArrayList<String> generateArrayListFromFile(String filename) throws IOException {
      List<String> result = FileUtils.readLines(new File(filename), "utf-8");

      return new ArrayList<>(result);
   }

}
