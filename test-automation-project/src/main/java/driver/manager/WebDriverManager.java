package driver.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverManager
{
    static WebDriver driver;

    public WebDriverManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public static void setDriver(WebDriver driver)
    {
        WebDriverManager.driver = driver;
    }

    public void click(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30L));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            element.click();
        } catch (final Exception e) {
            try {
                throw new Exception(e.getMessage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
