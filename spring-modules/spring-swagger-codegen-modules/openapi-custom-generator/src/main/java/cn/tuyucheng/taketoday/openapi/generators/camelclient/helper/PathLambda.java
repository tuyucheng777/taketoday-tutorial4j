package cn.tuyucheng.taketoday.openapi.generators.camelclient.helper;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;

public class PathLambda implements Mustache.Lambda {
   @Override
   public void execute(Template.Fragment fragment, Writer writer) throws IOException {
      String maybeUri = fragment.execute();
      try {
         URI uri = new URI(maybeUri);
         if (uri.getPath() != null) {
            writer.write(uri.getPath());
         } else {
            writer.write("/");
         }
      } catch (URISyntaxException e) {
         // Keep as is
         writer.write(maybeUri);
      }
   }
}