package mobile;

import base.BaseAndroidClass;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.mobile.BasketPage;
import pages.mobile.HomePage;
import pages.mobile.ProductDetailPage;
import pages.mobile.SearchResultPage;

public class ProductTest extends BaseAndroidClass
{
    private HomePage homePage;
    private static final String MOBILE_PHONE_SEARCH_TERM = "iphone 16 pro max";

    @BeforeMethod
    public void setUp()
    {
        homePage = new HomePage(mobileDriverManager);
        homePage.clickPermissionAllowButton();
        Assert.assertTrue(homePage.assertHomePage());
    }

    @Description("Kelime ile arama > ürün detay > sepete ekleme kontrolü")
    @Test
    public void testProductAddToBasket()
    {
        SearchResultPage searchResultPage = homePage
                .sendKeysSearchBox(MOBILE_PHONE_SEARCH_TERM)
                .clickFirstSearchSuggestion();

        ProductDetailPage productDetailPage = searchResultPage.clickFirstProduct();

        String productTitle = productDetailPage.getTextProductTitle();
        String productPrice = productDetailPage.getTextProductPrice();

        BasketPage basketPage = productDetailPage
                .clickAddToBasket()
                .clickGoToBasket();

        Assert.assertTrue(productTitle.contains(basketPage.getTextProductName()));
        Assert.assertTrue(basketPage.getTextProductPrice().contains(productPrice));
    }
}
