package pages.web;

import driver.manager.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends PageObject
{
    public NewsPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @FindBy(id = "h-latest-news")
    private WebElement latestNewsTitle;

    @FindBy(xpath = "//div[contains(@class,'loop-card loop-card--post-type-post loop-card--default loop-card--horizontal loop-card--wide loop-card--force-storyline-aspect-ratio')]")
    private List<WebElement> latestNewsList;

    @FindBy(xpath = "//*[@class = 'loop-card__figure']")
    private List<WebElement> newsImage;

    @FindBy(xpath = "//*[@class = 'loop-card__figure']")
    private List<WebElement> newsAuthor;

    public NewsDetailPage clickNewsImage(int index)
    {
        newsImage.get(index).click();
        return new NewsDetailPage(webDriverManager);
    }

    public String getTextNewsTitle()
    {
        return latestNewsTitle.getText();
    }

    public int getSizeLatestNewsList()
    {
        return latestNewsList.size();
    }

    public String getTextNewsAuthor(int index)
    {
        return newsAuthor.get(index).getText();
    }

    public boolean isDisplayedNewsImage(int index)
    {
        return newsImage.get(index).isDisplayed();
    }
}
