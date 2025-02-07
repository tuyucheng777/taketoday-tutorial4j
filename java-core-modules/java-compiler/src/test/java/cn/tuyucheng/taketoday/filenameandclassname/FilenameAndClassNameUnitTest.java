package cn.tuyucheng.taketoday.filenameandclassname;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilenameAndClassNameUnitTest {

   @Test
   void whenNoPublicClassInSourceFile_thenCorrect() {
      Club manUnited = new Club("Manchester United F.C.");
      FootballPlayer rooney = new FootballPlayer("Wayne Rooney", manUnited);

      assertEquals("Wayne Rooney", rooney.getName());
      assertEquals("Manchester United F.C.", rooney.getClub().getName());
   }
}