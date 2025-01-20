package pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends PageObject
{

    @FindBy(id = "h-latest-news")
    private WebElement latestNewsTitle;

    // element methods

    public String getTextNewsTitle()
    {
        return latestNewsTitle.getText();
    }
}
