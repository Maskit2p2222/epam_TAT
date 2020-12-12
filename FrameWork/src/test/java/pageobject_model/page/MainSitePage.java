package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainSitePage extends AbstractPage {
    private static final String PAGE_URL= "https://www.e-katalog.ru/";

    @FindBy(id = "ek-search")
    private WebElement searchLine;

    @FindBy(xpath = "//button[@name='search_but_']")
    private WebElement searchButton;

    public MainSitePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainSitePage openPage() {
        webDriver.get(PAGE_URL);
        return this;
    }

    public QueryResultsPage searchForQuery(String query){
        searchLine.sendKeys(query);
        searchButton.click();
        return new QueryResultsPage(webDriver);
    }


}
