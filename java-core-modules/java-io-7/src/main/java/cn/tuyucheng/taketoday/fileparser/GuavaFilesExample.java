package cn.tuyucheng.taketoday.fileparser;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class GuavaFilesExample {

   static ArrayList<String> generateArrayListFromFile(String filename) throws IOException {
      List<String> result = Files.readLines(new File(filename), Charset.forName("utf-8"));

      return new ArrayList<>(result);
   }

}
