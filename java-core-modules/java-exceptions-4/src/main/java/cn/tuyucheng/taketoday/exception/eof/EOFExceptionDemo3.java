package cn.tuyucheng.taketoday.exception.eof;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class EOFExceptionDemo3 {
   public static void readInput() {
      InputStream is = new ByteArrayInputStream("1 2 3".getBytes());
      Scanner sc = new Scanner(is);
      while (sc.hasNextInt()) {
         int value = sc.nextInt();
         System.out.println("Input value: " + value);
      }
      System.out.println("End of file");
      sc.close();
   }
}