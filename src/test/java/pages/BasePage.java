package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {
    //protected static WebDriver driver;
    protected static RemoteWebDriver driver;

    public static void setDriver(RemoteWebDriver webDriver){
        driver = webDriver;
    }

}
