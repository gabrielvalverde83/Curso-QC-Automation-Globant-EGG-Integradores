package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    //constructor:
    public HomePage(WebDriver driver){
        super(driver);
    }

    ///////////////////////////////////////////////////////////////////

    @FindBy(css = "[name='search']")
    private WebElement searchInput;

    @FindBy(css = "#searchform button")
    private WebElement searchButton;


    ////////////////////////////////////////////////////////////////

    public ResultPage searchText(String text){
        waitElementVisibility(searchInput);
        searchInput.sendKeys(text);
        waitToBeClickable(searchButton);
        searchButton.click();
        return new ResultPage(super.getDriver());
    }




}
