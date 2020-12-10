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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSearchGoods {
    private WebDriver webDriver;

    @BeforeMethod (alwaysRun = true)
    public void setUpBrowser() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchForGoodsSamsung() {
        webDriver.get("https://www.e-katalog.ru/");
        WebElement searchLine = webDriver.findElement(By.id("ek-search"));
        searchLine.sendKeys("Телевизоры Samsung");
        WebElement searchButton = webDriver.findElement(By.xpath("//button[@name='search_but_']"));
        searchButton.click();
        List<WebElement> listOfGoods = new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='model-short-div list-item--goods   ']")));
        Assert.assertTrue(listOfGoods.get(0).findElement(By.xpath("//a[@class='model-short-title no-u']")).getText().toLowerCase().contains("samsung"));
    }

    @Test
    public void testSearchForGoodsApple() {
        webDriver.get("https://www.e-katalog.ru/");
        WebElement searchLine = webDriver.findElement(By.id("ek-search"));
        searchLine.sendKeys("Телефоны Apple");
        WebElement searchButton = webDriver.findElement(By.xpath("//button[@name='search_but_']"));
        searchButton.click();
        List<WebElement> listOfGoods = new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='model-short-div list-item--goods   ']")));
        Assert.assertTrue(listOfGoods.get(0).findElement(By.xpath("//a[@class='model-short-title no-u']")).getText().toLowerCase().contains("apple"));
    }

    @AfterMethod (alwaysRun = true)
    public void close() {
        webDriver.quit();
        webDriver = null;
    }

}
