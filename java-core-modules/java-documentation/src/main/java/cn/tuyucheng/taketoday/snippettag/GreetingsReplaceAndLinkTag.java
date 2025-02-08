package cn.tuyucheng.taketoday.snippettag;

/**
 *
 * Using the replace tag
 * {@snippet :
 * public void helloTaketoday() {
 *     System.out.println("Hello From Team Taketoday"); // @replace regex='".*"' replacement="..."
 * }
 * }
 * Using the link tag
 * {@snippet :
 * public void helloTaketoday() {
 *     System.out.println("Hello From Team Taketoday"); // @link substring="System.out" target="System#out"
 * }
 * }
 *
 */

public class GreetingsReplaceAndLinkTag {
    public void helloTaketoday() {
        System.out.println("Hello From Team Taketoday");
    }
}
