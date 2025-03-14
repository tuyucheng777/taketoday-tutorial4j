package cn.tuyucheng.taketoday.absolutetorelative;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AbsoluteToRelativeUnitTest {

   // given - until using Paths, no need to create physical files
   private final Path pathOne = Paths.get("/taketoday/bar/one.txt");
   private final Path pathTwo = Paths.get("/taketoday/bar/two.txt");
   private final Path pathThree = Paths.get("/taketoday/foo/three.txt");

   private final URI uriOne = pathOne.toUri();
   private final URI uriTwo = pathTwo.toUri();
   private final URI uriThree = pathThree.toUri();

   @Test
   public void givenAbsolutePaths_whenRelativizePathOneToPathTwo_thenRelativeIsReturned() {
      Path result = pathOne.relativize(pathTwo);

      org.assertj.core.api.Assertions.assertThat(result)
            .isRelative()
            .isEqualTo(Paths.get("../two.txt"));
   }

   @Test
   public void givenAbsolutePaths_whenRelativizePathTwoToPathOne_thenRelativeIsReturned() {
      Path result = pathTwo.relativize(pathOne);

      org.assertj.core.api.Assertions.assertThat(result)
            .isRelative()
            .isEqualTo(Paths.get("../one.txt"));
   }

   @Test
   public void givenAbsolutePaths_whenRelativizePathOneParentToPathTwo_thenRelativeIsReturned() {
      Path result = pathOne.getParent().relativize(pathTwo);

      org.assertj.core.api.Assertions.assertThat(result)
            .isRelative()
            .isEqualTo(Paths.get("two.txt"));
   }

   @Test
   public void givenAbsolutePaths_whenRelativizePathOneToPathThree_thenRelativeIsReturned() {
      Path result = pathOne.relativize(pathThree);

      org.assertj.core.api.Assertions.assertThat(result)
            .isRelative()
            .isEqualTo(Paths.get("../../foo/three.txt"));
   }

   @Test
   public void givenAbsolutePaths_whenRelativizePathThreeToPathOne_thenRelativeIsReturned() {
      Path result = pathThree.relativize(pathOne);

      org.assertj.core.api.Assertions.assertThat(result)
            .isRelative()
            .isEqualTo(Paths.get("../../bar/one.txt"));
   }

   @Test
   public void givenAbsoluteURIs_whenRelativizeUriOneToUriTwo_thenAbsoluteIsReturned() {
      URI result = uriOne.relativize(uriTwo);

      org.assertj.core.api.Assertions.assertThat(result)
            .asString()
            .contains("/taketoday/bar/two.txt");
   }

   @Test
   public void givenAbsoluteURIs_whenRelativizeUriOneParentToUriTwo_thenRelativeIsReturned() {
      URI result = pathOne.getParent().toUri().relativize(uriTwo);

      org.assertj.core.api.Assertions.assertThat(result)
            .asString()
            .contains("two.txt");
   }

   @Test
   public void givenAbsoluteURIs_whenRelativizeUriOneParentToUriThree_thenAbsoluteIsReturned() {
      URI result = pathOne.getParent().toUri().relativize(uriThree);

      org.assertj.core.api.Assertions.assertThat(result)
            .asString()
            .contains("/taketoday/foo/three.txt");
   }

}
