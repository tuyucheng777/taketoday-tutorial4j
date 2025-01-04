package cn.tuyucheng.taketoday.poi.replacevariables;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DocTextReplacer {

   public void replaceText() throws IOException {
      String filePath = getClass().getClassLoader()
            .getResource("taketoday.doc")
            .getPath();
      try (InputStream inputStream = new FileInputStream(filePath); POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream)) {
         HWPFDocument doc = new HWPFDocument(fileSystem);
         doc = replaceText(doc, "Taketoday", "Hello");
         saveFile(filePath, doc);
         doc.close();
      }
   }

   private HWPFDocument replaceText(HWPFDocument doc, String originalText, String updatedText) {
      Range range = doc.getRange();
      range.replaceText(originalText, updatedText);
      return doc;
   }

   private void saveFile(String filePath, HWPFDocument doc) throws IOException {
      try (FileOutputStream out = new FileOutputStream(filePath)) {
         doc.write(out);
      }
   }
}