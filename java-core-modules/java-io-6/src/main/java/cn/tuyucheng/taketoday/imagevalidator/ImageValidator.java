package cn.tuyucheng.taketoday.imagevalidator;

import org.apache.tika.Tika;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageValidator {

   public static boolean isImageFileUsingTika(File file) throws IOException {
      Tika tika = new Tika();
      String mimeType = tika.detect(file);
      return mimeType.startsWith("image/");
   }

   public static boolean isImageFileUsingImageIO(File file) throws IOException {
      BufferedImage image = ImageIO.read(file);
      return image != null;
   }

   public static boolean isImageFileUsingProbeContentType(File file) throws IOException {
      Path filePath = file.toPath();
      String mimeType = Files.probeContentType(filePath);
      return mimeType != null && mimeType.startsWith("image/");
   }

}
