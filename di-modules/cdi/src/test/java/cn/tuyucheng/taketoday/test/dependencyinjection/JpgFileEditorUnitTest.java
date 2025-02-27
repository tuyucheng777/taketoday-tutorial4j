package cn.tuyucheng.taketoday.test.dependencyinjection;

import cn.tuyucheng.taketoday.dependencyinjection.imagefileeditors.JpgFileEditor;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JpgFileEditorUnitTest {

   private static JpgFileEditor jpgFileUtil;

   @BeforeClass
   public static void setJpgFileEditorInstance() {
      jpgFileUtil = new JpgFileEditor();
   }

   @Test
   public void givenJpgFileEditorInstance_whenCalledopenFile_thenOneAssertion() {
      assertThat(jpgFileUtil.openFile("file1.jpg")).isEqualTo("Opening JPG file file1.jpg");
   }

   @Test
   public void givenJpgFileEditorlInstance_whenCallededitFile_thenOneAssertion() {
      assertThat(jpgFileUtil.editFile("file1.gif")).isEqualTo("Editing JPG file file1.gif");
   }

   @Test
   public void givenJpgFileEditorInstance_whenCalledwriteFile_thenOneAssertion() {
      assertThat(jpgFileUtil.writeFile("file1.jpg")).isEqualTo("Writing JPG file file1.jpg");
   }

   @Test
   public void givenJpgFileEditorInstance_whenCalledsaveFile_thenOneAssertion() {
      assertThat(jpgFileUtil.saveFile("file1.jpg")).isEqualTo("Saving JPG file file1.jpg");
   }
}