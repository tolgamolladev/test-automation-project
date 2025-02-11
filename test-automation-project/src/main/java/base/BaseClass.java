package base;

import driver.factory.WebDriverFactory;
import driver.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseClass extends WebDriverFactory
{
    protected static WebDriver driver;
    public WebDriverManager webDriverManager;


    @BeforeClass
    public void before() throws MalformedURLException {
        driver = createDriver();

        webDriverManager = new WebDriverManager(driver);

        driver.get("https://techcrunch.com/");
    }

    @AfterClass
    public void after()
    {
        driver.quit();
    }
}
