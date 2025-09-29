package cn.tuyucheng.taketoday.loose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class LooselyCouplingUnitTest {

   @Test
   public void givenMetadataCollector_thenCollectMetadataXMLAndExportCSV() {
      FetchMetadata metadata = new XMLFetch();
      ExportMetadata exportMetadata = new CSVExport();
      MetadataCollector collector = new MetadataCollector(metadata, exportMetadata);
      collector.collectMetadata();
      assertInstanceOf(CSVExport.class, collector.getExportMetadata());
      assertInstanceOf(XMLFetch.class, collector.getFetchMetadata());
   }

   @Test
   public void givenMetadataCollector_thenCollectMetadataUsingJSONAndExportPDF() {
      FetchMetadata metadata = new JSONFetch();
      ExportMetadata exportMetadata = new PDFExport();
      MetadataCollector collector = new MetadataCollector(metadata, exportMetadata);
      collector.collectMetadata();
      assertInstanceOf(PDFExport.class, collector.getExportMetadata());
      assertInstanceOf(JSONFetch.class, collector.getFetchMetadata());
   }

   @Test
   public void givenMetadataCollector_thenCollectMetadataUsingXMLAndExportPDF() {
      FetchMetadata metadata = new XMLFetch();
      ExportMetadata exportMetadata = new PDFExport();
      MetadataCollector collector = new MetadataCollector(metadata, exportMetadata);
      collector.collectMetadata();
      assertInstanceOf(PDFExport.class, collector.getExportMetadata());
      assertInstanceOf(XMLFetch.class, collector.getFetchMetadata());
   }
}