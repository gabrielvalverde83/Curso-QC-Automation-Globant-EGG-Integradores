package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.sql.Driver;

public class Test {
    SoftAssert softAssert = new SoftAssert();
    String name;
    String url = "https://swapi.dev/api";

    Response response;

    int num;
    WebDriver driver = new FirefoxDriver();

    /**************************************************************/
    /*Scenario 1*/

    @Given("I am an user at the Wikipedia WebPage requesting SW character {int}")
    public void i_am_an_user_at_the_wikipedia_web_page_requesting_sw_character(Integer int1) {

        response = RestAssured.given().get(url + "/people/" + int1);
        softAssert.assertEquals(response.getStatusCode(), 200);
        JsonPath jsonPath = response.jsonPath();
        name = jsonPath.get("name");

    }

    @When("I search the requested character name on Wikipedia search page")
    public void i_search_the_requested_character_name_on_wikipedia_search_page() {
        driver.navigate().to("https://www.wikipedia.org/");

        WebElement busqueda = driver.findElement(By.id("searchInput"));
        busqueda.isDisplayed();
        busqueda.isEnabled();
        busqueda.sendKeys(name);

        WebElement boton = driver.findElement(By.cssSelector(".pure-button"));
        boton.isDisplayed();
        boton.isEnabled();
        boton.click();
    }

    @Then("I should be able to see the article page correctly displayed for the requested character")
    public void i_should_be_able_to_see_the_article_page_correctly_displayed_for_the_requested_character() {
        WebElement titulo  = driver.findElement(By.cssSelector(".mw-page-title-main"));
        titulo.isDisplayed();
        titulo.isEnabled();
        softAssert.assertEquals(titulo.getText(),name);
        //driver.close();
    }

    /**************************************************************/
    /*Scenario 2*/

    @Before
    public void beforeTest(){
        num = (int)(Math.random()*6 +1);
    }

    /*el given, when y then son compartidos en el 2do y 3er escenario, están escritos igual*/
    @Given("I am an user at the Wikipedia WebPage requesting SW movie")
    public void i_am_an_user_at_the_wikipedia_web_page_requesting_sw_movie() {

        response = RestAssured.given().get(url + "/films/" +num);
        name = response.jsonPath().get("title");
    }

    @When("I search the requested movie name on Wikipedia search page")
    public void i_search_the_requested_movie_name_on_wikipedia_search_page() {
        driver.navigate().to("https://www.wikipedia.org/");
        /*
        WebElement lang = driver.findElement(By.id("searchLanguage"));
        lang.click();
        */
        driver.findElement(By.cssSelector("#searchLanguage option[value='en']")).click();

        WebElement busqueda = driver.findElement(By.id("searchInput"));
        busqueda.isDisplayed();
        busqueda.isEnabled();
        busqueda.sendKeys(name);

        WebElement boton = driver.findElement(By.cssSelector(".pure-button"));
        boton.isDisplayed();
        boton.isEnabled();
        boton.click();
    }

    /*este es el and que le sigue al when en el 1er escenario*/
    @When("go to the article page and click on the Edit Link")
    public void go_to_the_article_page_and_click_on_the_edit_link() {
        WebElement editButton = driver.findElement(By.id("ca-edit"));
        editButton.isDisplayed();
        editButton.isEnabled();
        editButton.click();
    }

    /*este es el and que le sigue al when en el 2do escenario*/
    @When("go to the article page and click on the Ver Historial Link")
    public void go_to_the_article_page_and_click_on_the_historial_link() {
        WebElement editButton = driver.findElement(By.id("ca-history"));
        editButton.isDisplayed();
        editButton.isEnabled();
        editButton.click();
    }

    @Then("Check the edit page is displayed correctly, including the matching of the title for the article page")
    public void check_the_edit_page_is_displayed_correctly_including_the_matching_of_the_title_for_the_article_page() {
        WebElement tituloEdit = driver.findElement(By.id("firstHeading"));
        /*System.out.println(name);*/
        String episodio ="";
        if(name.equalsIgnoreCase("A New Hope")) {
            Assert.assertEquals("Editing Star Wars (film)", tituloEdit.getText());
        }else
            Assert.assertTrue(tituloEdit.getText().contains(name));
    }

    @After
    public void after(){
        driver.quit();
    }
}