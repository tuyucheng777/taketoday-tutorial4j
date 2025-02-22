package cn.tuyucheng.taketoday.jsontojavaclass;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsonToJavaClassConversion {

   public static void main(String[] args) {
      String packageName = "cn.tuyucheng.taketoday.jsontojavaclass.pojo";
      String basePath = "src/main/resources";
      File inputJson = new File(basePath + File.separator + "input.json");
      File outputPojoDirectory = new File(basePath + File.separator + "convertedPojo");
      outputPojoDirectory.mkdirs();
      try {
         new JsonToJavaClassConversion().convertJsonToJavaClass(inputJson.toURI().toURL(), outputPojoDirectory, packageName, inputJson.getName().replace(".json", ""));
      } catch (IOException e) {
         System.out.println("Encountered issue while converting to pojo: " + e.getMessage());
         e.printStackTrace();
      }
   }


   public void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory, String packageName, String javaClassName) throws IOException {
      JCodeModel jcodeModel = new JCodeModel();

      GenerationConfig config = new DefaultGenerationConfig() {
         @Override
         public boolean isGenerateBuilders() {
            return true;
         }

         @Override
         public SourceType getSourceType() {
            return SourceType.JSON;
         }
      };

      SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
      mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);

      jcodeModel.build(outputJavaClassDirectory);
   }

}
