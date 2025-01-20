package driver.factory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory
{
    private static WebDriver driver;

    public static WebDriver createDriver()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver");
        return new ChromeDriver();
    }

}
