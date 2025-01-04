package cn.tuyucheng.taketoday.convert.exceldatatolist;

import cn.tuyucheng.taketoday.convert.exceldatatolist.fastexcel.ExcelDataToListOfObjectsFastExcel;
import cn.tuyucheng.taketoday.convert.exceldatatolist.jexcelapi.ExcelDataToListOfObjectsJxl;
import cn.tuyucheng.taketoday.convert.exceldatatolist.poi.ExcelDataToListApachePOI;
import cn.tuyucheng.taketoday.convert.exceldatatolist.poiji.ExcelDataToListOfObjectsPOIJI;
import jxl.read.biff.BiffException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExcelDataToListOfObjectsUnitTest {

   @Test
   public void whenParsingExcelFileWithPOIJI_thenConvertsToList() throws IOException {
      List<FoodInfo> foodInfoList = ExcelDataToListOfObjectsPOIJI.excelDataToListOfObjets_withPOIJI("src/main/resources/food_info.xlsx");

      assertEquals("Beverages", foodInfoList.get(0).getCategory());
      assertEquals("Dairy", foodInfoList.get(3).getCategory());
   }

   @Test
   public void whenParsingExcelFileWithApachePOI_thenConvertsToList() throws IOException {
      List<FoodInfo> foodInfoList = ExcelDataToListApachePOI.excelDataToListOfObjets_withApachePOI("src/main/resources/food_info.xlsx");

      assertEquals("Beverages", foodInfoList.get(0).getCategory());
      assertEquals("Dairy", foodInfoList.get(3).getCategory());
   }

   @Test
   public void whenParsingExcelFileWithFastExcel_thenConvertsToList() throws IOException {
      List<FoodInfo> foodInfoList = ExcelDataToListOfObjectsFastExcel.excelDataToListOfObjets_withFastExcel("src/main/resources/food_info.xlsx");

      assertEquals("Beverages", foodInfoList.get(0).getCategory());
      assertEquals("Dairy", foodInfoList.get(3).getCategory());
   }

   @Test
   public void whenParsingExcelFileWithJxl_thenConvertsToList() throws IOException, BiffException {
      List<FoodInfo> foodInfoList = ExcelDataToListOfObjectsJxl.excelDataToListOfObjets_withJxl("src/main/resources/food_info.xls");

      assertEquals("Beverages", foodInfoList.get(0).getCategory());
      assertEquals("Dairy", foodInfoList.get(3).getCategory());
   }
}