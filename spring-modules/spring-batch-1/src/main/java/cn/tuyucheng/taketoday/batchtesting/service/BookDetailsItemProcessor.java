package cn.tuyucheng.taketoday.batchtesting.service;

import cn.tuyucheng.taketoday.batchtesting.model.BookDetails;
import cn.tuyucheng.taketoday.batchtesting.model.BookRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BookDetailsItemProcessor implements ItemProcessor<BookRecord, BookDetails> {

   private static Logger LOGGER = LoggerFactory.getLogger(BookDetailsItemProcessor.class);

   @Override
   public BookDetails process(BookRecord item) {
      BookDetails bookDetails = new BookDetails();
      bookDetails.setBookFormat(item.getBookFormat());
      bookDetails.setBookISBN(item.getBookISBN());
      bookDetails.setPublishingYear(item.getPublishingYear());
      bookDetails.setBookName(item.getBookName());
      LOGGER.info("Processing bookdetails {}", bookDetails);
      return bookDetails;
   }
}