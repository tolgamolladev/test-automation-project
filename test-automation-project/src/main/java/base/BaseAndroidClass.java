package base;

import driver.factory.MobileDriverFactory;
import driver.manager.MobileDriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;


public class BaseAndroidClass extends MobileDriverFactory
{

    protected static AppiumDriver driver;

    @BeforeClass
    public void before() throws MalformedURLException
    {
        driver = createDriver();

        MobileDriverManager.setDriver(driver);
    }


}
