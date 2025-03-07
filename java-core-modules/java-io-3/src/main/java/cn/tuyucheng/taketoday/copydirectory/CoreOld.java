package cn.tuyucheng.taketoday.copydirectory;

import java.io.*;

public class CoreOld {

   public static void copyDirectoryJavaUnder7(File source, File destination) throws IOException {
      if (source.isDirectory()) {
         copyDirectory(source, destination);
      } else {
         copyFile(source, destination);
      }
   }

   private static void copyDirectory(File sourceDirectory, File destinationDirectory) throws IOException {
      if (!destinationDirectory.exists()) {
         destinationDirectory.mkdir();
      }
      for (String f : sourceDirectory.list()) {
         copyDirectoryJavaUnder7(new File(sourceDirectory, f), new File(destinationDirectory, f));
      }
   }

   private static void copyFile(File sourceFile, File destinationFile) throws IOException {
      try (InputStream in = new FileInputStream(sourceFile); OutputStream out = new FileOutputStream(destinationFile)) {
         byte[] buf = new byte[1024];
         int length;
         while ((length = in.read(buf)) > 0) {
            out.write(buf, 0, length);
         }
      }
   }
}
