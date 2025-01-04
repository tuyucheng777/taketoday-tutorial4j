package cn.tuyucheng.taketoday.poi.excel.cellstyle;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class CellBorderHandlerUnitTest {
   private static final String FILE_NAME = "cellstyle/CellStyleBorderHandlerTest.xlsx";
   private static final int SHEET_INDEX = 0;

   private static CellBordersHandler cellBordersHandler;
   private static Workbook workbook;

   @BeforeClass
   public static void setup() throws URISyntaxException, IOException {
      String fileLocation = Paths.get(ClassLoader.getSystemResource(FILE_NAME).toURI()).toString();
      cellBordersHandler = new CellBordersHandler();
      workbook = new XSSFWorkbook(fileLocation);
      createRowsAndCells(workbook);
   }

   private static void createRowsAndCells(Workbook workbook) {
      Sheet sheet = workbook.getSheetAt(SHEET_INDEX);
      for (int rowIndex = 0; rowIndex < 10; rowIndex++) {
         Row row = sheet.getRow(rowIndex);
         if (row == null) {
            row = sheet.createRow(rowIndex);
         }
         for (int colIndex = 0; colIndex < 10; colIndex++) {
            Cell cell = row.getCell(colIndex);
            if (cell == null) {
               row.createCell(colIndex);
            }
         }
      }
   }

   @Test
   public void givenWorkbookCell_whenSetRegionBorder() {
      Sheet sheet = workbook.getSheetAt(SHEET_INDEX);

      CellRangeAddress region = new CellRangeAddress(1, 1, 1, 1);
      cellBordersHandler.setRegionBorder(region, sheet, BorderStyle.THICK);

      Row row = sheet.getRow(1);
      Cell cell = row.getCell(1);
      assertEquals(BorderStyle.THICK, cell.getCellStyle().getBorderTop());
      assertEquals(BorderStyle.THICK, cell.getCellStyle().getBorderBottom());
      assertEquals(BorderStyle.THICK, cell.getCellStyle().getBorderLeft());
      assertEquals(BorderStyle.THICK, cell.getCellStyle().getBorderRight());
   }

   @Test
   public void givenWorkbookCell_whenSetRegionBorderWithColor() {
      Sheet sheet = workbook.getSheetAt(SHEET_INDEX);

      CellRangeAddress region = new CellRangeAddress(1, 1, 3, 3);
      cellBordersHandler.setRegionBorderWithColor(region, sheet, BorderStyle.THICK, IndexedColors.MAROON.index);

      Row row = sheet.getRow(1);
      Cell cell = row.getCell(1 + 2);
      assertEquals(BorderStyle.THICK, cell.getCellStyle().getBorderTop());
      assertEquals(BorderStyle.THICK, cell.getCellStyle().getBorderBottom());
      assertEquals(BorderStyle.THICK, cell.getCellStyle().getBorderLeft());
      assertEquals(BorderStyle.THICK, cell.getCellStyle().getBorderRight());
      assertEquals(IndexedColors.MAROON.index, cell.getCellStyle().getTopBorderColor());
      assertEquals(IndexedColors.MAROON.index, cell.getCellStyle().getBottomBorderColor());
      assertEquals(IndexedColors.MAROON.index, cell.getCellStyle().getLeftBorderColor());
      assertEquals(IndexedColors.MAROON.index, cell.getCellStyle().getRightBorderColor());
   }

   @Test
   public void givenWorkbookCell_whenSetCrazyBorder() {
      Sheet sheet = workbook.getSheetAt(SHEET_INDEX);

      CellRangeAddress region = new CellRangeAddress(1, 1, 5, 5);
      cellBordersHandler.setCrazyBorder(region, sheet);

      Row row = sheet.getRow(1);
      Cell cell = row.getCell(5);
      assertEquals(BorderStyle.DASH_DOT, cell.getCellStyle().getBorderTop());
      assertEquals(BorderStyle.DOUBLE, cell.getCellStyle().getBorderBottom());
      assertEquals(BorderStyle.DOTTED, cell.getCellStyle().getBorderLeft());
      assertEquals(BorderStyle.SLANTED_DASH_DOT, cell.getCellStyle().getBorderRight());
      assertEquals(IndexedColors.RED.index, cell.getCellStyle().getTopBorderColor());
      assertEquals(IndexedColors.GREEN.index, cell.getCellStyle().getBottomBorderColor());
      assertEquals(IndexedColors.BLUE.index, cell.getCellStyle().getLeftBorderColor());
      assertEquals(IndexedColors.VIOLET.index, cell.getCellStyle().getRightBorderColor());
   }

   @Test
   public void givenWorkbookRegion_whenSetRegionBorder() {
      Sheet sheet = workbook.getSheetAt(SHEET_INDEX);

      CellRangeAddress region = new CellRangeAddress(3, 5, 1, 5);
      cellBordersHandler.setRegionBorder(region, sheet, BorderStyle.MEDIUM);

      Row row = sheet.getRow(3);
      Cell cell = row.getCell(1);
      assertEquals(BorderStyle.MEDIUM, cell.getCellStyle().getBorderTop());
      assertEquals(BorderStyle.MEDIUM, cell.getCellStyle().getBorderLeft());
   }

   @Test
   public void givenWorkbookRegion_whenSetRegionBorderWithColor() {
      Sheet sheet = workbook.getSheetAt(SHEET_INDEX);

      CellRangeAddress region = new CellRangeAddress(7, 8, 1, 5);
      cellBordersHandler.setRegionBorderWithColor(region, sheet, BorderStyle.MEDIUM, IndexedColors.ORANGE.index);

      Row row = sheet.getRow(7);
      Cell cell = row.getCell(1);
      assertEquals(BorderStyle.MEDIUM, cell.getCellStyle().getBorderTop());
      assertEquals(BorderStyle.MEDIUM, cell.getCellStyle().getBorderLeft());
      assertEquals(IndexedColors.ORANGE.index, cell.getCellStyle().getTopBorderColor());
      assertEquals(IndexedColors.ORANGE.index, cell.getCellStyle().getLeftBorderColor());
   }

   @AfterClass
   public static void close() throws IOException {
      workbook.close();
   }
}