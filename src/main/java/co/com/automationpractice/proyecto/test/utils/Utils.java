package co.com.automationpractice.proyecto.test.utils;

import co.com.automationpractice.proyecto.test.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Utils {
    public WebDriver driver;

    public void abirAplicacion(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void openApplication(String browser, String url) {
        driver = DriverFactory.getDriver(browser, true, true);
        driver.get(url);
    }



    public WebDriver getDriver(){
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
