package driver.manager;

import org.openqa.selenium.WebDriver;

public class WebDriverManager
{
    static WebDriver driver;

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void setDriver(WebDriver driver)
    {
        WebDriverManager.driver = driver;
    }

}
