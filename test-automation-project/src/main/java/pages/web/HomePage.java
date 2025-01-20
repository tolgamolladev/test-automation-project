package pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject
{

  @FindBy(xpath = "//li[@class = ' wp-block-navigation-item wp-block-navigation-link']/a[@href = '/latest/']")
  private WebElement latestTab;

  public NewsPage clickLatestTab()
  {
      latestTab.click();
      return new NewsPage();
  }
}
