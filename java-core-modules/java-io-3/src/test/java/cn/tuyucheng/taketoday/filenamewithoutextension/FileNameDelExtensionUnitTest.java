package cn.tuyucheng.taketoday.filenamewithoutextension;

import com.google.common.io.Files;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FileNameDelExtensionUnitTest {

   @Test
   public void givenDotFileWithoutExt_whenCallGuavaMethod_thenCannotGetDesiredResult() {
      // negative assertion
      assertNotEquals(".taketoday", Files.getNameWithoutExtension(".taketoday"));
   }

   @Test
   public void givenFileWithoutMultipleExt_whenCallGuavaMethod_thenCannotRemoveAllExtensions() {
      // negative assertion
      assertNotEquals("taketoday", Files.getNameWithoutExtension("taketoday.tar.gz"));
   }

   @Test
   public void givenDotFileWithoutExt_whenCallApacheCommonsMethod_thenCannotGetDesiredResult() {
      // negative assertion
      assertNotEquals(".taketoday", FilenameUtils.removeExtension(".taketoday"));
   }

   @Test
   public void givenFileWithoutMultipleExt_whenCallApacheCommonsMethod_thenCannotRemoveAllExtensions() {
      // negative assertion
      assertNotEquals("taketoday", FilenameUtils.removeExtension("taketoday.tar.gz"));
   }

   @Test
   public void givenFilenameNoExt_whenCallFilenameUtilMethod_thenGetExpectedFilename() {
      assertEquals("taketoday", MyFilenameUtil.removeFileExtension("taketoday", true));
      assertEquals("taketoday", MyFilenameUtil.removeFileExtension("taketoday", false));
   }

   @Test
   public void givenSingleExt_whenCallFilenameUtilMethod_thenGetExpectedFilename() {
      assertEquals("taketoday", MyFilenameUtil.removeFileExtension("taketoday.txt", true));
      assertEquals("taketoday", MyFilenameUtil.removeFileExtension("taketoday.txt", false));
   }


   @Test
   public void givenDotFile_whenCallFilenameUtilMethod_thenGetExpectedFilename() {
      assertEquals(".taketoday", MyFilenameUtil.removeFileExtension(".taketoday", true));
      assertEquals(".taketoday", MyFilenameUtil.removeFileExtension(".taketoday", false));
   }

   @Test
   public void givenDotFileWithExt_whenCallFilenameUtilMethod_thenGetExpectedFilename() {
      assertEquals(".taketoday", MyFilenameUtil.removeFileExtension(".taketoday.conf", true));
      assertEquals(".taketoday", MyFilenameUtil.removeFileExtension(".taketoday.conf", false));
   }

   @Test
   public void givenDoubleExt_whenCallFilenameUtilMethod_thenGetExpectedFilename() {
      assertEquals("taketoday", MyFilenameUtil.removeFileExtension("taketoday.tar.gz", true));
      assertEquals("taketoday.tar", MyFilenameUtil.removeFileExtension("taketoday.tar.gz", false));
   }

   @Test
   public void givenDotFileWithDoubleExt_whenCallFilenameUtilMethod_thenGetExpectedFilename() {
      assertEquals(".taketoday", MyFilenameUtil.removeFileExtension(".taketoday.conf.bak", true));
      assertEquals(".taketoday.conf", MyFilenameUtil.removeFileExtension(".taketoday.conf.bak", false));
   }
}
