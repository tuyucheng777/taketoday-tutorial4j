package cn.tuyucheng.taketoday.ipc;

import org.junit.jupiter.api.Test;

import java.nio.file.*;

public class DirectoryLiveTest {
   @Test
   public void consumer() throws Exception {
      WatchService watchService = FileSystems.getDefault().newWatchService();
      // Set this to an appropriate directory.
      Path path = Paths.get("/tmp/ipc");

      path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

      WatchKey key;
      while ((key = watchService.take()) != null) {
         for (WatchEvent<?> event : key.pollEvents()) {
            // React to new file.
            System.out.println(event);
         }
         key.reset();
      }
   }
}