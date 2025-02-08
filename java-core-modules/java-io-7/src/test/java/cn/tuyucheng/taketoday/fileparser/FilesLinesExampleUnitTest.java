package cn.tuyucheng.taketoday.fileparser;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FilesLinesExampleUnitTest {

   private static final String TEXT_FILENAME = "src/test/resources/sampleTextFile.txt";

   @Test
   void whenParsingExistingTextFile_thenGetArrayList() throws IOException {
      List<String> lines = FilesLinesExample.generateArrayListFromFile(TEXT_FILENAME);
      assertTrue(lines.size() == 2, "File does not has 2 lines");
   }

}
