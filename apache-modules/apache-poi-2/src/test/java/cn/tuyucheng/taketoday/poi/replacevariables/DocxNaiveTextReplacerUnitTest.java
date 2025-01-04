package cn.tuyucheng.taketoday.poi.replacevariables;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DocxNaiveTextReplacerUnitTest {

   @Test
   void whenReplaceText_ThenTextReplaced() throws IOException {
      new DocxNaiveTextReplacer().replaceText();

      String filePath = getClass().getClassLoader()
            .getResource("taketoday-copy.docx")
            .getPath();
      try (FileInputStream fis = new FileInputStream(filePath); XWPFDocument document = new XWPFDocument(fis); XWPFWordExtractor extractor = new XWPFWordExtractor(document)) {
         long occurrencesOfHello = Arrays.stream(extractor.getText()
                     .split("\\s+"))
               .filter(s -> s.contains("Hello"))
               .count();
         assertTrue(occurrencesOfHello < 5);
      }
   }
}