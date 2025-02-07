package cn.tuyucheng.taketoday.searchfilesbywildcards;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileByWildcard {
   public static List<String> matchesList = new ArrayList<String>();

   public List<String> searchWithWc(Path rootDir, String pattern) throws IOException {
      matchesList.clear();
      FileVisitor<Path> matcherVisitor = new SimpleFileVisitor<Path>() {
         @Override
         public FileVisitResult visitFile(Path file, BasicFileAttributes attribs) throws IOException {
            FileSystem fs = FileSystems.getDefault();
            PathMatcher matcher = fs.getPathMatcher(pattern);
            Path name = file.getFileName();
            if (matcher.matches(name)) {
               matchesList.add(name.toString());
            }
            return FileVisitResult.CONTINUE;
         }
      };
      Files.walkFileTree(rootDir, matcherVisitor);
      return matchesList;
   }
}