package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QueryResultsPageWithMaxPriceFilter extends AbstractPage {

    private static final By byFirstElementName = By.id("price_1780444");

    protected QueryResultsPageWithMaxPriceFilter(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getFirstElementPriceLabel(){
        return  driverWait.until(ExpectedConditions
                        .presenceOfElementLocated(byFirstElementName)).getText();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }
}
