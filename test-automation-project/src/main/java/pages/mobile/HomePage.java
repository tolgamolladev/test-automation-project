package pages.mobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends AndroidPageObject
{

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/textViewLocation")
    private WebElement selectLocation;

    @AndroidFindBy(id = "//androidx.compose.ui.platform.ComposeView[@content-desc=\"locationComponentOnHome\"]/android.view.View/android.view.View\n")
    private WebElement locationComponentOnHomePage;

    // click methods

    public HomePage clickSelectLocation()
    {
        selectLocation.click();
        return this;
    }

    // isDisplayed methods

    public boolean isDisplayedLocationComponentOnHomePage()
    {
        return locationComponentOnHomePage.isDisplayed();
    }
}
