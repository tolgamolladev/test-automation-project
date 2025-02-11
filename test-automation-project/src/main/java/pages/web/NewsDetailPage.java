package pages.web;

import driver.manager.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.IntStream;

public class NewsDetailPage extends PageObject
{
    public NewsDetailPage(WebDriverManager webDriverManager)
    {
        super(webDriverManager);
    }

    @FindBy(xpath = "//h1[@class = 'article-hero__title wp-block-post-title']")
    private WebElement newsTitle;

    @FindBy(xpath = "//a[@class = 'wp-block-techcrunch-social-share__link']")
    private List<WebElement> socialMediaLinkList;

    public String getTextNewsTitle()
    {
        return newsTitle.getText();
    }

    public void checkSocialMediaLinksIsEmpty()
    {
        Assert.assertTrue(socialMediaLinkList.size() > 0 );

        IntStream
                .range(0, socialMediaLinkList.size())
                .forEach((i) -> {
                    Assert.assertFalse(socialMediaLinkList.get(i).getAttribute("href").isEmpty());
        });
    }
}
