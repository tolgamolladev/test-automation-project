package pages.web;

import driver.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject
{
    protected WebDriverManager webDriverManager;
    protected PageObject(WebDriverManager webDriverManager)
    {
        this.webDriverManager = webDriverManager;
        PageFactory.initElements(webDriverManager.getDriver(), this);
    }



}
