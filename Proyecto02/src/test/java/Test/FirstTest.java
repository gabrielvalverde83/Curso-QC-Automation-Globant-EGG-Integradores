package Test;

import org.example.pages.HomePage;
import org.example.pages.SearchResults;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

public class FirstTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testWiki () {

        HomePage homePage = getHomePage();


        softAssert.assertEquals(homePage.getAmountLanguage(), 10);
        softAssert.assertEquals(homePage.getFooterText(), "You can support our work with a donation.");

        homePage.setBarText("Selenium");

        SearchResults searchResults = homePage.clickOnSearch();
        softAssert.assertEquals(searchResults.getPageText(), "Selenium");



        softAssert.assertAll(); //es muy importante esta fc porque con los soft assert si falla uno, no nos enteramos

    }
}
