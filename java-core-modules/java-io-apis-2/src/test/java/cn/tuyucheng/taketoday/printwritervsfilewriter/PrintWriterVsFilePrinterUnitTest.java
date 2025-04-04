package cn.tuyucheng.taketoday.printwritervsfilewriter;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrintWriterVsFilePrinterUnitTest {

   @Test
   public void whenWritingToTextFileUsingFileWriter_thenTextMatches() throws IOException {
      String result = "Harry Potter and the Chamber of Secrets";

      File file = new File("potter.txt");
      try (FileWriter fw = new FileWriter(file);) {
         fw.write("Harry Potter and the Chamber of Secrets");
      }

      try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
         String actualData = reader.readLine();
         assertEquals(result, actualData);
      }
   }

   @Test
   public void whenWritingToTextFileUsingPrintWriterPrintf_thenTextMatches() throws IOException {
      String result = "Dreams from My Father by Barack Obama";
      File file = new File("dream.txt");
      try (PrintWriter pw = new PrintWriter(file);) {
         String author = "Barack Obama";
         pw.printf("Dreams from My Father by %s", author);
         assertTrue(!pw.checkError());
      }

      try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
         String actualData = reader.readLine();
         assertEquals(result, actualData);
      }
   }

   @Test
   public void whenWritingToTextFileUsingPrintWriterPrintln_thenTextMatches() throws IOException {
      String result = "I'm going to Alabama\nAlabama is a state in the US\n";
      try (PrintWriter pw = new PrintWriter("alabama.txt");) {
         pw.println("I'm going to Alabama");
         pw.println("Alabama is a state in the US");
      }
      Path path = Paths.get("alabama.txt");
      String actualData = new String(Files.readAllBytes(path));
      assertEquals(result, actualData);
   }

}
