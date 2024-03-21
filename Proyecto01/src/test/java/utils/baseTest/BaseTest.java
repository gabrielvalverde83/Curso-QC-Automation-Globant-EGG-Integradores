package utils.baseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;
import utils.MyDriver;

public class BaseTest {

    MyDriver driver;

    //esto se va a ejecutar antes de cada metodo
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeMethod(String browser, String url) {
        driver = new MyDriver(browser);
        driver.getDriver().manage().window().maximize();
        navigateTo(url);    //navega a la pagina a través de un método
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    //creo metodos para hacerlo mas sencillo, mas fácil de leer y reutilizable
    //navego a tal pagina, muchas paginas lo usan, por eso va aca
    public void navigateTo(String url) {
        driver.getDriver().get(url);    //con el get navegamos a la pagina
    }

    //cargo la primer pagina, llamo al constructor de HomePage
    //no me meto a hacer las cosas de la pagina en si
    public HomePage loadFirstPage() {
        return new HomePage(driver.getDriver());
    }

    //cierro el driver
    @AfterMethod()
    public void afterMethod() {
        driver.getDriver().close();
    }
}
