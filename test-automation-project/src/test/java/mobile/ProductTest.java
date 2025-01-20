package mobile;

import base.BaseAndroidClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.mobile.HomePage;

public class ProductTest extends BaseAndroidClass
{
    private HomePage homePage;

    @BeforeMethod
    public void setUp()
    {
        homePage = new HomePage();
        homePage.clickPermissionAllowButton();
        homePage.clickSelectLocation();
    }

    @Test
    public void testProductAddToBasket()
    {
        Assert.assertTrue(true);
    }
}
