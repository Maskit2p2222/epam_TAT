package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QueryResultsPageWithMaxPriceFilter extends AbstractPage {

    private final By byFirstElementName = By.id("price_1780444");

    protected QueryResultsPageWithMaxPriceFilter(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getFirstElementPriceLabel(){
        return  new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(byFirstElementName)).getText();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }
}
