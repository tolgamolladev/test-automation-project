package pages.web;

import driver.manager.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject
{

    public HomePage(WebDriverManager webDriverManager)
    {
        super(webDriverManager);
    }

    @FindBy(xpath = "//li[@class = ' wp-block-navigation-item wp-block-navigation-link']/a[@href = '/latest/']")
  private WebElement latestTab;

  public NewsPage clickLatestTab()
  {
      webDriverManager.click(latestTab);
      return new NewsPage(webDriverManager);
  }
}
