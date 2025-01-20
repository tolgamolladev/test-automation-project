package pages.web;

import driver.manager.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class PageObject
{
    protected PageObject()
    {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

}
