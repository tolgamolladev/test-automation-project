package driver.manager;

import io.appium.java_client.AppiumDriver;

public class MobileDriverManager
{
    public static AppiumDriver getDriver()
    {
        return driver;
    }

    public static void setDriver(AppiumDriver driver)
    {
        MobileDriverManager.driver = driver;
    }

    static AppiumDriver driver;
}
