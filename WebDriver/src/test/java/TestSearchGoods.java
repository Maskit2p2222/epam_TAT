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
    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchForGoodsSamsung() {
        driver.get("https://www.e-katalog.ru/");
        WebElement searchLine = driver.findElement(By.id("ek-search"));
        searchLine.sendKeys("Телевизоры Samsung");
        WebElement searchButton = driver.findElement(By.xpath("//button[@name='search_but_']"));
        searchButton.click();
        List<WebElement> listOfGoods = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='model-short-div list-item--goods   ']")));
        Assert.assertTrue(listOfGoods.get(0).findElement(By.xpath("//a[@class='model-short-title no-u']")).getText().toLowerCase().contains("samsung"));
    }

    @Test
    public void testSearchForGoodsApple() {
        driver.get("https://www.e-katalog.ru/");
        WebElement searchLine = driver.findElement(By.id("ek-search"));
        searchLine.sendKeys("Телефоны Apple");
        WebElement searchButton = driver.findElement(By.xpath("//button[@name='search_but_']"));
        searchButton.click();
        List<WebElement> listOfGoods = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='model-short-div list-item--goods   ']")));
        Assert.assertTrue(listOfGoods.get(0).findElement(By.xpath("//a[@class='model-short-title no-u']")).getText().toLowerCase().contains("apple"));
    }

    @AfterMethod (alwaysRun = true)
    public void close() {
        driver.quit();
        driver = null;
    }

}
