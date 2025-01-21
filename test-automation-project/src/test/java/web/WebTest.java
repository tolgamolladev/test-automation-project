package web;

import base.BaseClass;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.web.HomePage;
import pages.web.NewsDetailPage;
import pages.web.NewsPage;

import java.util.stream.IntStream;

public class WebTest extends BaseClass
{
    private NewsPage newsPage;

    @BeforeMethod
    public void setUp()
    {
        HomePage homePage = new HomePage();
        newsPage = homePage.clickLatestTab();
    }

    @Description("Son haberler sayfasında her haberin bir resmi ve yazarı olduğunu kontrol eder.")
    @Test
    public void testNewsComponents()
    {
        Assert.assertEquals(newsPage.getTextNewsTitle(), "Latest News");

        IntStream
                .range(0, newsPage.getSizeLatestNewsList() - 1)
                .forEach((i) -> {
                    Assert.assertFalse(newsPage.getTextNewsAuthor(i).isEmpty());
                    Assert.assertTrue(newsPage.isDisplayedNewsImage(i));
        });
    }

    @Description("Son haberler sayfası > haber detay sayfası başlık ve bağlantı linklerinin olduğu kontrolü ")
    @Test
    public void testNewsDetail()
    {
        NewsDetailPage newsDetailPage = newsPage.clickNewsImage(0);

        Assert.assertEquals(newsDetailPage.getTextNewsTitle(), driver.getTitle());

        newsDetailPage.checkSocialMediaLinksIsEmpty();
    }


}
