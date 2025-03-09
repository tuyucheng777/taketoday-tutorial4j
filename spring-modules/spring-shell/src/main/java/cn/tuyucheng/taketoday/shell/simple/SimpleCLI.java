package cn.tuyucheng.taketoday.shell.simple;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;

@Component
public class SimpleCLI implements CommandMarker {

   private String getContentsOfUrlAsString(URL url) {
      StringBuilder sb = new StringBuilder();
      try {
         try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
               sb.append(inputLine);
            }
         }
      } catch (IOException ex) {
         sb.append("ERROR");
      }
      return sb.toString();
   }

   @CliCommand(value = {"web-get", "wg"}, help = "Displays the contents of a URL.")
   public String webGet(@CliOption(key = {"", "url"}, help = "URL whose contents will be displayed.") URL url) {
      return getContentsOfUrlAsString(url);
   }

   @CliCommand(value = {"web-save", "ws"}, help = "Saves the contents of a URL.")
   public String webSave(@CliOption(key = {"", "url"}, help = "URL whose contents will be saved.") URL url, @CliOption(key = {"out", "file"}, mandatory = true, help = "The name of the file.") String file) {
      String contents = getContentsOfUrlAsString(url);
      try (PrintWriter out = new PrintWriter(file)) {
         out.write(contents);
      } catch (FileNotFoundException ex) {
         // Ignore
      }
      return "Done.";
   }

   private boolean adminEnableExecuted = false;

   @CliAvailabilityIndicator(value = {"web-save"})
   public boolean isAdminEnabled() {
      return adminEnableExecuted;
   }

   @CliCommand(value = "admin-enable")
   public String adminEnable() {
      adminEnableExecuted = true;
      return "Admin commands enabled.";
   }

   @CliCommand(value = "admin-disable")
   public String adminDisable() {
      adminEnableExecuted = false;
      return "Admin commands disabled.";
   }
}