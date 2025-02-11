package base;

import driver.factory.MobileDriverFactory;
import driver.manager.MobileDriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.time.Duration;


public class BaseAndroidClass extends MobileDriverFactory
{

    protected AppiumDriver driver;
    protected MobileDriverManager mobileDriverManager;

    @BeforeClass
    public void before() throws MalformedURLException
    {
        driver = createDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        mobileDriverManager = new MobileDriverManager(driver);
    }


}
