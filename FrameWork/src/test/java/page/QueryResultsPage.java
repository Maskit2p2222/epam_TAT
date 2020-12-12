package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QueryResultsPage extends AbstractPage {

    private final By byFirstElementName = By.xpath("//a[@class='model-short-title no-u']/span");

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }

    protected QueryResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getFirstElementName() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(byFirstElementName)).getText();
    }
}