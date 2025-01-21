package pages.mobile;

import driver.manager.MobileDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends AndroidPageObject
{
    public BasketPage(MobileDriverManager mobileDriverManager)
    {
        super(mobileDriverManager.getDriver());
    }

    @FindBy(xpath = "//*[@resource-id = 'productName']")
    private WebElement productName;

    @FindBy(xpath = "//android.widget.TextView[@resource-id = 'basket_price']")
    private WebElement productPrice;

    public String getTextProductName()
    {
        return productName.getText();
    }

    public String getTextProductPrice()
    {
        return productPrice.getText().replaceAll("[^0-9]", "");
    }
}
