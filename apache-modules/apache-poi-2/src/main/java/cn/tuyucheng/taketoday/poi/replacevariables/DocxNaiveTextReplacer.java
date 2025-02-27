package cn.tuyucheng.taketoday.poi.replacevariables;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DocxNaiveTextReplacer {

   public void replaceText() throws IOException {
      String filePath = getClass().getClassLoader()
            .getResource("taketoday-copy.docx")
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
      List<XWPFRun> runs = paragraph.getRuns();
      for (XWPFRun run : runs) {
         String text = run.getText(0);
         if (text != null && text.contains(originalText)) {
            String updatedRunText = text.replace(originalText, updatedText);
            run.setText(updatedRunText, 0);
         }
      }
   }

   private void saveFile(String filePath, XWPFDocument doc) throws IOException {
      try (FileOutputStream out = new FileOutputStream(filePath)) {
         doc.write(out);
      }
   }
}