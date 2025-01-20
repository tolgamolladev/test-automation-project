package web;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.web.HomePage;
import pages.web.NewsPage;

public class WebTest extends BaseClass
{
    private NewsPage newsPage;

    @BeforeMethod
    public void setUp()
    {
        HomePage homePage = new HomePage();
        newsPage = homePage.clickLatestTab();
    }

    @Test
    public void test()
    {
        Assert.assertEquals(newsPage.getTextNewsTitle(), "Latest News");
    }
}
