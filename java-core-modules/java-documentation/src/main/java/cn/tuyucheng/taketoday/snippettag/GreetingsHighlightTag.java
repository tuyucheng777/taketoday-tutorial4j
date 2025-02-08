package cn.tuyucheng.taketoday.snippettag;


/**
 * The code below shows a full highlighted line
 * {@snippet :
 * public void helloTaketoday() {
 *     System.out.println("Hello From Team Taketoday"); // @highlight
 * }
 * }
 *
 * highlighting a substring
 * {@snippet :
 * public void helloTaketoday() {
 *     System.out.println("Hello From Team Taketoday"); // @highlight substring="println"
 * }
 * }
 *
 * highlighting texts on multiple lines
 * {@snippet :
 * public void helloTaketoday() {
 *     System.out.println("Hello From Team Taketoday"); // @highlight region substring="println"
 *     String country = "USA";
 *     System.out.println("Hello From Team " + country); // @end
 * }
 * }
 *
 */

public class GreetingsHighlightTag {
    public void helloTaketoday() {
        System.out.println("Hello From Team Taketoday");
    }

}
