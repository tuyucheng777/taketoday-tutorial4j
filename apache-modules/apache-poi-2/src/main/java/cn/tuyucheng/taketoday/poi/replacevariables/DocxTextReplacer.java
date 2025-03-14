package cn.tuyucheng.taketoday.poi.replacevariables;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DocxTextReplacer {

   public void replaceText() throws IOException {
      String filePath = getClass().getClassLoader()
            .getResource("taketoday.docx")
            .getPath();
      try (InputStream inputStream = new FileInputStream(filePath)) {
         XWPFDocument doc = new XWPFDocument(inputStream);
         doc = replaceText(doc, "Taketoday", "Hello");
         saveFile(filePath, doc);
         doc.close();
      }
   }

   private XWPFDocument replaceText(XWPFDocument doc, String originalText, String updatedText) {
      replaceTextInParagraphs(doc.getParagraphs(), originalText, updatedText);
      for (XWPFTable tbl : doc.getTables()) {
         for (XWPFTableRow row : tbl.getRows()) {
            for (XWPFTableCell cell : row.getTableCells()) {
               replaceTextInParagraphs(cell.getParagraphs(), originalText, updatedText);
            }
         }
      }
      return doc;
   }

   private void replaceTextInParagraphs(List<XWPFParagraph> paragraphs, String originalText, String updatedText) {
      paragraphs.forEach(paragraph -> replaceTextInParagraph(paragraph, originalText, updatedText));
   }

   private void replaceTextInParagraph(XWPFParagraph paragraph, String originalText, String updatedText) {
      String paragraphText = paragraph.getParagraphText();
      if (paragraphText.contains(originalText)) {
         String updatedParagraphText = paragraphText.replace(originalText, updatedText);
         while (!paragraph.getRuns().isEmpty()) {
            paragraph.removeRun(0);
         }
         XWPFRun newRun = paragraph.createRun();
         newRun.setText(updatedParagraphText);
      }
   }

   private void saveFile(String filePath, XWPFDocument doc) throws IOException {
      try (FileOutputStream out = new FileOutputStream(filePath)) {
         doc.write(out);
      }
   }
}