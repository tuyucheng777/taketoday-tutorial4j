package cn.tuyucheng.taketoday.dependencyinjection.imageprocessors;

import cn.tuyucheng.taketoday.dependencyinjection.imagefileeditors.ImageFileEditor;
import cn.tuyucheng.taketoday.dependencyinjection.loggers.TimeLogger;
import cn.tuyucheng.taketoday.dependencyinjection.qualifiers.PngFileEditorQualifier;
import jakarta.inject.Inject;

public class ImageFileProcessor {

   private final ImageFileEditor imageFileEditor;
   private final TimeLogger timeLogger;

   @Inject
   public ImageFileProcessor(@PngFileEditorQualifier ImageFileEditor imageFileEditor, TimeLogger timeLogger) {
      this.imageFileEditor = imageFileEditor;
      this.timeLogger = timeLogger;
   }

   public ImageFileEditor getImageFileditor() {
      return imageFileEditor;
   }

   public TimeLogger getTimeLogger() {
      return timeLogger;
   }

   public String openFile(String fileName) {
      return imageFileEditor.openFile(fileName) + " at: " + timeLogger.getTime();
   }

   public String editFile(String fileName) {
      return imageFileEditor.editFile(fileName) + " at: " + timeLogger.getTime();
   }

   public String writeFile(String fileName) {
      return imageFileEditor.writeFile(fileName) + " at: " + timeLogger.getTime();
   }

   public String saveFile(String fileName) {
      return imageFileEditor.saveFile(fileName) + " at: " + timeLogger.getTime();
   }
}