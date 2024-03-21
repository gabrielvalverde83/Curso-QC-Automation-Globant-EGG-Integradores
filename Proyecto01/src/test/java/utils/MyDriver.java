package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class MyDriver {

    private WebDriver driver;

    //constructor del driver
    public MyDriver(String browser){
        if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        }
        else {
            String path = System.getProperty("user.dir");
            System.out.println(path);
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabri\\OneDrive\\Documentos\\Gabriel\\1-Cursos\\1-EggGlobantQA\\0001-ProyectoIntegrador\\chrome-driver\\chromedriver.exe");  //+path, parte de la raiz del proyecto, esto es porque cada desarrollador no tiene la misma ubicación de la carpeta del proyecto en su disco
            driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver(){
        return this.driver;
    }

}
