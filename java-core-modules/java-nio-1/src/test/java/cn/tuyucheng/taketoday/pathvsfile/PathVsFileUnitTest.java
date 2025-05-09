package cn.tuyucheng.taketoday.pathvsfile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

public class PathVsFileUnitTest {

   @Test
   public void whenCreateFileAndPath_thenShouldPointTheSame() {
      File file = new File("taketoday/tutorial.txt");
      Path path = Paths.get("taketoday/tutorial.txt");

      assertThat(file.toString())
            .isEqualTo(path.toString());
      assertThat(file.toPath())
            .isEqualTo(path);
      assertThat(path.toFile())
            .isEqualTo(file);
      assertThat(file)
            .isEqualTo(new File("taketoday", "tutorial.txt"));
      assertThat(path)
            .isEqualTo(Paths.get("taketoday", "tutorial.txt"))
            .isEqualTo(Paths.get("taketoday").resolve("tutorial.txt"));
   }

   @Test
   public void givenNoFile_whenDelete_thenReportError() {
      File file = new File("tutorial.txt");
      Path path = Paths.get("tutorial.txt");

      assertThat(file.delete()).isFalse();
      assertThatThrownBy(() -> Files.delete(path))
            .isInstanceOf(IOException.class)
            .isInstanceOf(NoSuchFileException.class);
   }

   @Test
   public void givenExistedFile_whenReadMetadata_thenShouldBeSame() throws IOException {
      File file = new File("tutorial.txt");
      Path path = Paths.get("tutorial.txt");

      Throwable throwable = catchThrowable(() -> Files.createFile(path));
      assertThat(throwable)
            .isNull();

      assertThat(file.exists())
            .isEqualTo(Files.exists(path));
      assertThat(file.isFile())
            .isEqualTo(Files.isRegularFile(path));
      assertThat(file.isDirectory())
            .isEqualTo(Files.isDirectory(path));
      assertThat(file.canRead())
            .isEqualTo(Files.isReadable(path));
      assertThat(file.canWrite())
            .isEqualTo(Files.isWritable(path));
      assertThat(file.canExecute())
            .isEqualTo(Files.isExecutable(path));
      assertThat(file.isHidden())
            .isEqualTo(Files.isHidden(path));
   }

   @Test
   public void givenExistedFile_whenUriPathOperations_thenShouldBeSame() throws IOException {
      File file = new File("tutorial.txt");
      Path path = Paths.get("tutorial.txt");

      Throwable throwable = catchThrowable(() -> Files.createFile(path));
      assertThat(throwable)
            .isNull();

      assertThat(file.toURI())
            .isEqualTo(path.toUri());
      assertThat(file.getAbsolutePath())
            .isEqualTo(path.toAbsolutePath().toString());
      assertThat(file.getCanonicalPath())
            .isEqualTo(path.toRealPath().toString())
            .isEqualTo(path.toRealPath().normalize().toString());
   }

   @AfterEach
   public void afterEach() throws IOException {
      Path path = Paths.get("tutorial.txt");
      if (Files.exists(path)) {
         Files.delete(path);
      }
   }
}
