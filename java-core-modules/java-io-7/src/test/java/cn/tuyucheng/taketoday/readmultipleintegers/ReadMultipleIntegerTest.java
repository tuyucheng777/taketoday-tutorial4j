package cn.tuyucheng.taketoday.readmultipleintegers;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadMultipleIntegerTest {

   private static final String FILE_PATH = "src/test/resources/intinputs.txt";
   private static final int EXPECTED_NO_OF_INTEGERS = 5;

   @Test
   public void givenFile_whenUsingBufferedReader_thenExtractedIntegersCorrect() throws IOException {
      try (BufferedReader br = Files.newBufferedReader(Paths.get(FILE_PATH))) {
         String inputs = br.readLine();
         int[] requiredInputs = Arrays.stream(inputs.split(" ")).mapToInt(Integer::parseInt).toArray();

         assertEquals(EXPECTED_NO_OF_INTEGERS, requiredInputs.length);
      }
   }

   @Test
   public void givenFile_whenUsingScannerNextInt_thenExtractedIntegersCorrect() throws IOException {
      try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
         List<Integer> inputs = new ArrayList<>();
         while (scanner.hasNext()) {
            inputs.add(scanner.nextInt());
         }

         assertEquals(EXPECTED_NO_OF_INTEGERS, inputs.size());
      }
   }

   @Test
   public void givenFile_whenUsingScannerNextLine_thenExtractedIntegersCorrect() throws IOException {
      try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
         String inputs = scanner.nextLine();
         int[] requiredInputs = Arrays.stream(inputs.split(" ")).mapToInt(Integer::parseInt).toArray();

         assertEquals(EXPECTED_NO_OF_INTEGERS, requiredInputs.length);
      }
   }
}