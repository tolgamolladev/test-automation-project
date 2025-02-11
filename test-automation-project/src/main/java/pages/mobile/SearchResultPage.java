package pages.mobile;

import driver.manager.MobileDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AndroidPageObject
{
    public SearchResultPage(MobileDriverManager mobileDriverManager) {
        super(mobileDriverManager);
    }

    @FindBy(id = "com.pozitron.hepsiburada:id/composeProductBoxView")
    private List<WebElement> productList;

    public ProductDetailPage clickFirstProduct()
    {
        mobileDriverManager.click(productList.get(0));
        return new ProductDetailPage(mobileDriverManager);
    }
}
