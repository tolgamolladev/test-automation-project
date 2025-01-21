package pages.mobile;

import driver.manager.MobileDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AndroidPageObject
{
    public HomePage(MobileDriverManager mobileDriverManager)
    {
        super(mobileDriverManager.getDriver());
    }

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@content-desc=\"locationComponentOnHome\"]/android.view.View/android.view.View\n")
    private WebElement locationComponentOnHomePage;

    @FindBy(id = "com.pozitron.hepsiburada:id/etSearchBox")
    private WebElement searchBox;

    @FindBy(id = "com.pozitron.hepsiburada:id/search_suggestion")
    private List<WebElement> searcSuggestionList;

    public SearchResultPage clickFirstSearchSuggestion()
    {
        searcSuggestionList.get(1).click();
        return new SearchResultPage(mobileDriverManager);
    }

    public HomePage sendKeysSearchBox(String searchTerm)
    {
        mobileDriverManager.click(searchBox);
        mobileDriverManager.sendKeys(searchBox, searchTerm);
        return this;
    }

    public boolean assertHomePage()
    {
        return locationComponentOnHomePage.isDisplayed();
    }
}
