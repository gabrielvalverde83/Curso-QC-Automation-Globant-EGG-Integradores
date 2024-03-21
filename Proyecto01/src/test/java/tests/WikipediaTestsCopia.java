package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultPage;
import utils.baseTest.BaseTest;

import static org.testng.Assert.assertTrue;

public class WikipediaTestsCopia extends BaseTest {

    //el textToSearch se va a sacar del suite.xml - puedo reutilizarlo
    @Test
    @Parameters({ "textToSearch" })
    public void searchTest(String textToSearch){
        HomePage home = loadFirstPage();
        ResultPage results = home.searchText(textToSearch);

        assertTrue(results.isTitleCorrect(textToSearch), "The title does not match");
    }

    @Test
    @Parameters({ "textToSearch2" })
    public void searchTest2(String textToSearch){
        HomePage home = loadFirstPage();
        ResultPage results = home.searchText(textToSearch);

        assertTrue(results.isTitleCorrect(textToSearch), "The title does not match");
    }
}