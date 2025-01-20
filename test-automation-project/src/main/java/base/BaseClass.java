package base;

import driver.factory.WebDriverFactory;
import driver.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass extends WebDriverFactory
{
    protected static WebDriver driver;

    @BeforeClass
    public void before()
    {
        driver = createDriver();

        driver.get("https://techcrunch.com/");
    }

    @AfterClass
    public void after()
    {
        driver.quit();
    }
}
