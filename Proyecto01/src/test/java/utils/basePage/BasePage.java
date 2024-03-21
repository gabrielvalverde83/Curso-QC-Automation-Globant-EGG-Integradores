package utils.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    ////////////////////////////////////////////////////////////////////////////
    //constructor de BasePage que van a usar las paginas hijas
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);         //el this es el contexto
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));  //Explicit wait: Los wait esperan que se cumplan condiciones en las paginas pero sino Le configuro el timeOut global
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //Getters
    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //Fc waits
    public void waitToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }


    public void waitElementVisibility(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }


    //esta fc es pesima práctica, es un Implicit wait, es la ultima opcion para hacer andar algo y luego lo arreglamos
    public void waitSomeSeconds(int time) {
        try{
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

