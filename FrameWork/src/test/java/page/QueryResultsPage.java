package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QueryResultsPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private final By byFirstElementName = By.xpath("//a[@class='model-short-title no-u']/span");

    @FindBy(id = "maxPrice_")
    private WebElement maxPriceInput;

    @FindBy(id = "match_submit")
    private WebElement submitFiltersButton;

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }

    protected QueryResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.driver, this);
    }

    public QueryResultsPageWithMaxPriceFilter applySpecifiedFilter(String maxPrice){
        this.maxPriceInput.sendKeys(maxPrice);
        logger.info("Send into " + maxPriceInput.getTagName() +" key - " + maxPrice);
        this.submitFiltersButton.click();
        logger.info("Clicked on " + submitFiltersButton.getTagName());
        return new QueryResultsPageWithMaxPriceFilter(driver);

    }

    public String getFirstElementName() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(byFirstElementName)).getText();
    }
}