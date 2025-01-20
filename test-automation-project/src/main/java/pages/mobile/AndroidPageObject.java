package pages.mobile;

import driver.manager.MobileDriverManager;
import org.openqa.selenium.support.PageFactory;

public class AndroidPageObject
{
    protected AndroidPageObject()
    {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

}
