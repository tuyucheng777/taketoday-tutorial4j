package cn.tuyucheng.taketoday.selenium.automatedbrowsertesting;

import cn.tuyucheng.taketoday.selenium.automatedbrowsertesting.pages.HomePage;
import cn.tuyucheng.taketoday.selenium.automatedbrowsertesting.pages.Mp3PlayersPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AutomatedBrowserTest extends BaseTest {

   @Test
   public void whenUserNavigatesToMp3PlayersPage_thenPageHeaderShouldBeCorrectlyDisplayed() {
      getDriver().get("https://ecommerce-playground.lambdatest.io/");

      HomePage homePage = new HomePage(getDriver());
      homePage.openShopByCategoryMenu();
      Mp3PlayersPage mp3PlayersPage = homePage.navigateToMp3PlayersPage();
      assertEquals(mp3PlayersPage.pageHeader(), "MP3 Players");
   }
}