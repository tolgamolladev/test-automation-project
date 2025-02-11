package pages.mobile;

import driver.manager.MobileDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AndroidPageObject
{
    public MobileDriverManager mobileDriverManager;

    protected AndroidPageObject(MobileDriverManager mobileDriverManager)
    {
        this.mobileDriverManager = mobileDriverManager;
        PageFactory.initElements(mobileDriverManager.getDriver(), this);
    }

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement permissionAllowButton;

    public void clickPermissionAllowButton()
    {
        mobileDriverManager.click(permissionAllowButton);
    }

}
