package pageobject_model.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.MainSitePage;


public class TestSearchGoods {
    private WebDriver webDriver;

    @BeforeMethod (alwaysRun = true)
    public void setUpBrowser() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void testSearchForGoodsSamsung() {
        String firstElementName = new MainSitePage(webDriver)
                .openPage()
                .searchForQuery("Телевизоры Samsung")
                .getFirstElementName();
        Assert.assertTrue(firstElementName.toLowerCase().contains("samsung"));
    }

    @Test
    public void testSearchForGoodsApple() {
        String firstElementName = new MainSitePage(webDriver)
                .openPage()
                .searchForQuery("Телефоны Apple")
                .getFirstElementName();
        Assert.assertTrue(firstElementName.toLowerCase().contains("apple"));
    }

    @Test
    public void testSearchForGoodsXiaomi(){
        String firstElementName = new MainSitePage(webDriver)
                .openPage()
                .searchForQuery("Телефоны Xiaomi")
                .getFirstElementName();
        Assert.assertTrue(firstElementName.toLowerCase().contains("xiaomi"));
    }

    @AfterMethod (alwaysRun = true)
    public void close() {
        webDriver.quit();
        webDriver = null;
    }

}
