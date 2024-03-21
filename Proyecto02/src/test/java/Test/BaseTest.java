package Test;

import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;

    HomePage homePage;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabri\\OneDrive\\Documentos\\Gabriel\\1-Cursos\\1-EggGlobantQA\\0001-ProyectoIntegrador\\chrome-driver\\chromedriver.exe");  //+path, parte de la raiz del proyecto, esto es porque cada desarrollador no tiene la misma ubicación de la carpeta del proyecto en su disco
        driver = new ChromeDriver();    //abre el navegador
    }

    @AfterTest
    public void afterTest(){
        driver.close();
    }



    public HomePage getHomePage() {
        homePage = new HomePage(driver, "https://www.wikipedia.org" );
        return homePage;
    }




}
