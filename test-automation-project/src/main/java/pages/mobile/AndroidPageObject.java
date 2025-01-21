package pages.mobile;

import driver.manager.MobileDriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AndroidPageObject
{
    public MobileDriverManager mobileDriverManager;

    protected AndroidPageObject(AppiumDriver driver)
    {
        mobileDriverManager = new MobileDriverManager(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement permissionAllowButton;

    //

    public void clickPermissionAllowButton()
    {
        mobileDriverManager.click(permissionAllowButton);
    }

}
