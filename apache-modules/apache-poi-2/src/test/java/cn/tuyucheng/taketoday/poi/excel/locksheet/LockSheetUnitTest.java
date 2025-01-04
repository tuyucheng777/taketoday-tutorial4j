package cn.tuyucheng.taketoday.poi.excel.locksheet;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LockSheetUnitTest {

   private LockSheet lockSheet;
   private Workbook workbook;
   private Sheet sheet;

   @BeforeEach
   void setup() {
      workbook = new XSSFWorkbook();
      sheet = workbook.createSheet();
      Row row = sheet.createRow(0);
      row.createCell(0).setCellValue("row 1 col 1");
      row.createCell(1).setCellValue("row 1 col 2");
      row = sheet.createRow(1);
      row.createCell(0).setCellValue("row 2 col 1");
      row.createCell(1).setCellValue("row 2 col 2");
      lockSheet = new LockSheet();
   }

   @AfterEach
   void cleanup() throws IOException {
      workbook.close();
   }

   @Test
   void whenLockFirstRow_thenFirstRowIsLocked() {
      lockSheet.lockFirstRow(sheet);
      assertEquals(1, sheet.getPaneInformation().getHorizontalSplitPosition());
   }

   @Test
   void whenLockTwoRows_thenTwoRowsAreLocked() {
      lockSheet.lockTwoRows(sheet);
      assertEquals(2, sheet.getPaneInformation().getHorizontalSplitPosition());
   }

   @Test
   void whenLockFirstColumn_thenFirstColumnIsLocked() {
      lockSheet.lockFirstColumn(sheet);
      assertEquals(1, sheet.getPaneInformation().getVerticalSplitPosition());
   }
}