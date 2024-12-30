package cn.tuyucheng.taketoday.iTextPDFTest;

import static com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor.getTextFromPage;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import cn.tuyucheng.taketoday.iTextPDF.StoryTime;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;

class GenerateNewPdfWithWatermarkUnitTest {

   @Test
   public void givenNewTexts_whenGeneratingNewPDFWithIText_thenGeneratePDFwithWatermarks() throws IOException {
      StoryTime storyTime = new StoryTime();
      String waterMark = "CONFIDENTIAL";

      LocationTextExtractionStrategy extStrategy = new LocationTextExtractionStrategy();
      try (PdfDocument pdfDocument = new PdfDocument(new PdfReader(storyTime.OUTPUT_FILE))) {
         for (int i = 1; i <= pdfDocument.getNumberOfPages(); i++) {
            String textFromPage = getTextFromPage(pdfDocument.getPage(i), extStrategy);
            assertThat(textFromPage).contains(waterMark);
         }
      }
   }
}