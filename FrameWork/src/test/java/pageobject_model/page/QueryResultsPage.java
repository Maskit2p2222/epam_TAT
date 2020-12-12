package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QueryResultsPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='model-short-title no-u']")
    private WebElement firstElementName;

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }

    protected QueryResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getFirstElementName() {
        return firstElementName.getText();
    }
}
