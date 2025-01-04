package cn.tuyucheng.taketoday.apache.opennlp;

import opennlp.tools.langdetect.*;
import opennlp.tools.util.*;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class LanguageDetectorAndTrainingDataUnitTest {

   @Test
   public void givenLanguageDictionary_whenLanguageDetect_thenLanguageIsDetected() throws FileNotFoundException, IOException {
      InputStreamFactory dataIn = new MarkableFileInputStreamFactory(new File("src/main/resources/models/DoccatSample.txt"));
      ObjectStream lineStream = new PlainTextByLineStream(dataIn, "UTF-8");
      LanguageDetectorSampleStream sampleStream = new LanguageDetectorSampleStream(lineStream);
      TrainingParameters params = new TrainingParameters();
      params.put(TrainingParameters.ITERATIONS_PARAM, 100);
      params.put(TrainingParameters.CUTOFF_PARAM, 5);
      params.put("DataIndexer", "TwoPass");
      params.put(TrainingParameters.ALGORITHM_PARAM, "NAIVEBAYES");

      LanguageDetectorModel model = LanguageDetectorME.train(sampleStream, params, new LanguageDetectorFactory());

      LanguageDetector ld = new LanguageDetectorME(model);
      Language[] languages = ld.predictLanguages("estava em uma marcenaria na Rua Bruno");

      assertThat(Arrays.asList(languages)).extracting("lang", "confidence").contains(tuple("pob", 0.9999999950605625),
            tuple("ita", 4.939427661577956E-9), tuple("spa", 9.665954064665144E-15),
            tuple("fra", 8.250349924885834E-25));
   }
}