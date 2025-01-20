package pages.mobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends AndroidPageObject
{

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/textViewLocation")
    private WebElement selectLocation;


    public HomePage clickSelectLocation()
    {
        selectLocation.click();
        return this;
    }
}
