package pages.mobile;

import driver.manager.MobileDriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidPageObject
{
    protected AndroidPageObject()
    {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement permissionAllowButton;

    //

    public void clickPermissionAllowButton()
    {
        permissionAllowButton.click();
    }

}
