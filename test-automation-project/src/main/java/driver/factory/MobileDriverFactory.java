package driver.factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriverFactory {

    private static AppiumDriver driver;

    public static AppiumDriver createDriver() throws MalformedURLException
    {
        DesiredCapabilities androidCaps = new DesiredCapabilities();
        androidCaps.setCapability("appium:deviceName", "emulator_tolga");
        androidCaps.setCapability("appium:automationName", "uiautomator2");
        androidCaps.setCapability("appium:udid", "emulator-5554"); //DeviceId from "adb devices" command
        androidCaps.setCapability("appium:platformName", "Android");
        androidCaps.setCapability("appium:platformVersion", "15.0");
        androidCaps.setCapability("appium:newCommandTimeout", "600");
        androidCaps.setCapability("appium:appPackage", "com.pozitron.hepsiburada");
        androidCaps.setCapability("appium:appActivity", "com.hepsiburada.ui.startup.SplashActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidCaps);

        return driver;
    }
}
