package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class QueryResultsPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='u']")
    private List<WebElement> listOfAllNameLabels;

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
        logger.info("Send into " + this.maxPriceInput.getTagName() +" key - " + maxPrice);
        this.submitFiltersButton.click();
        logger.info("Clicked on " + this.submitFiltersButton.getTagName());
        return new QueryResultsPageWithMaxPriceFilter(driver);

    }

    public List<String> getAllElementsName() {
        List<String> listOfAllNames = new ArrayList<>();
        for (WebElement element:
                listOfAllNameLabels) {
            logger.info(element.getText());
            listOfAllNames.add(element.getText());
        }
        return listOfAllNames;
    }
}