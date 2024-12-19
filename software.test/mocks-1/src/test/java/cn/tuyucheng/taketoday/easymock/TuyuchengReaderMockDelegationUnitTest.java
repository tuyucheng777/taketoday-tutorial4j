package cn.tuyucheng.taketoday.easymock;

import org.easymock.EasyMockSupport;
import org.junit.Test;

import static org.easymock.EasyMock.expect;

public class TuyuchengReaderMockDelegationUnitTest {

   EasyMockSupport easyMockSupport = new EasyMockSupport();

   @Test
   public void givenBaeldungReader_whenReadAndWriteSequencially_thenWorks() {
      ArticleReader mockArticleReader = easyMockSupport.createMock(ArticleReader.class);
      IArticleWriter mockArticleWriter = easyMockSupport.createMock(IArticleWriter.class);
      TuyuchengReader tuyuchengReader = new TuyuchengReader(mockArticleReader, mockArticleWriter);

      expect(mockArticleReader.next()).andReturn(null);
      expect(mockArticleWriter.write("title", "content")).andReturn("");
      easyMockSupport.replayAll();

      tuyuchengReader.readNext();
      tuyuchengReader.write("title", "content");
      easyMockSupport.verifyAll();
   }

}