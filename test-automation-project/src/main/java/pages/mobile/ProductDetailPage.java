package pages.mobile;

import driver.manager.MobileDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends AndroidPageObject
{
    public ProductDetailPage(MobileDriverManager mobileDriverManager) {
        super(mobileDriverManager.getDriver());
    }

    @FindBy(xpath = "//*[@resource-id = 'summaryTitleComponent']/android.widget.TextView")
    private WebElement productTitle;

    @FindBy(xpath = "//*[@resource-id = 'com.pozitron.hepsiburada:id/pdpAddToCart']/preceding-sibling::androidx.compose.ui.viewinterop.ViewFactoryHolder/android.widget.TextView")
    private WebElement productPrice;

    @FindBy(id = "com.pozitron.hepsiburada:id/pdpAddToCart")
    private WebElement addToBasket;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Sepete git')]")
    private WebElement goToBasket;

    public ProductDetailPage clickAddToBasket()
    {
        mobileDriverManager.click(addToBasket);
        return this;
    }

    public BasketPage clickGoToBasket()
    {
        mobileDriverManager.click(goToBasket);
        return new BasketPage(mobileDriverManager);
    }

    public String getTextProductTitle()
    {
        return productTitle.getText();
    }

    public String getTextProductPrice()
    {
        String price = productPrice.getText().replaceAll("[^0-9]", "");
        return price;
    }
}
