package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePage {

    @FindBy(id = "searchInput")   //al buscar por ID no va nada adelante
    private WebElement searchInput;

    @FindBy(css = "button[type=\"submit\"]")     //notar como se escribe con las barritas y los "
    private WebElement submitBtn;

    @FindBy(css = ".footer-sidebar-text + div.footer-sidebar-text")
    private WebElement footerText;

    @FindBy(className = "central-featured-lang")
    private List<WebElement> lang_list;

    /****************************************************************************************/

    public void setBarText(String text) {    //recibo string
        this.searchInput.sendKeys(text);    //le envia(set)
    }

    public SearchResults clickOnSearch() {
        this.submitBtn.click();
        return new SearchResults(this.driver);
    }

    public String getFooterText() {
        this.isElementDisplayed(this.footerText);   //uso el waiting del BasePage
        return this.footerText.getText();
    }

    public int getAmountLanguage() {
        //this.isElementDisplayed(this.lang_list);   //uso el waiting del BasePage
        return this.lang_list.size();
    }


    /****************************************************************************************/

    public HomePage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
    }

    /****************************************************************************************/
    /****************************************************************************************/
    /****************************************************************************************/

    // anteriormente lo llamabamos del FirstTest:
    // WebElement submitBtn = driver.findElement(By.cssSelector("button[type=\"submit\"]"));   //no le coloco ., porque es un button class????
    // WebElement searchInput = driver.findElement(By.id("searchInput"));
    // WebElement footerlink = driver.findElement(By.cssSelector(".footer-sidebar-text + div.footer-sidebar-text"));
    // List<WebElement> lang_list = driver.findElements(By.className("central-featured-lang"));
    // y el driver lo habiamos colocado FirstTest - ahora lo llevamos a BasePage

    //sin crear funciones:

    //searchInput.sendKeys("Selenium");
    //softAssert.assertTrue(submitBtn.isDisplayed()); //se fija si el boton existe antes de dar click
    //submitBtn.click();  //le da click a la lupita y pasa a la pag de selenium
    //Assert.assertEquals(footerLink.getText(), "Puedes apoyar nuestro trabajo con una donación.");
    //WebDriverWait wait = new WebDriverWait(driver, 10);
    //

     /*List<WebElement> lang_list2 =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(
                        "central-featured-lang")));
     softAssert.assertEquals(lang_list.size(), 10);
      */
}