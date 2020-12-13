package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private String productPageUrl;

    @FindBy(xpath = "//h1[@class='t2 no-mobile']/b[@class='ib']")
    private WebElement productNameLabel;

    @FindBy(xpath= "//div[@class='ib toggle-off']/label")
    private WebElement addToComparisonComboBox;

    @FindBy(xpath = "//span[@class='addto-wishlist heart-empty heart_1644502']")
    private WebElement addToBookmarksButton;

    @FindBy(xpath = "//div[@id='stripe_bm_compared']/a/div[@class='side-list-label ' or @class ='side-list-label visited']")
    private List<WebElement> itemsAddedToComparison;

    @FindBy(id="name_bm_marked")
    private WebElement bookmarksButton;

    @FindBy(xpath = "//div[@class='side-list-label ']")
    private WebElement productInBookmarksLabel;

    @FindBy(xpath = "//div[@class='header']/*/*/div[@class='header_logo']/a[@href='https://www.e-katalog.ru/']")
    private WebElement mainLogo;

    @FindBy(id = "num_bm_compared")
    private WebElement countOfCompressingElementsSpan;

    @FindBy(xpath = "//span[@class='goods-bar-ico']")
    private WebElement goToCompressionButton;

    @FindBy(id = "bar_bm_compared")
    private WebElement openCompressionItemsListButton;


    public ProductPage(WebDriver driver, String pageUrl) {
        super(driver);
        this.productPageUrl = pageUrl;

        PageFactory.initElements(this.driver, this);
    }

    public ProductPage goToNewPage(String pageUrl){
        driver.navigate().to(pageUrl);
        logger.info("Opened page " +  pageUrl);
        return new ProductPage(driver,pageUrl);
    }

    public String getCountOfCompressingElementsSpan(){
        return this.countOfCompressingElementsSpan.getText();
    }

    public List<String> getItemsAddedToComparisonText(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> phoneModelsNames = new ArrayList<>();
        for (WebElement element :
                this.itemsAddedToComparison) {
            phoneModelsNames.add(element.getText());
        }
        return phoneModelsNames;
    }

    public ProductPage openComparisonItemListMenu(){
        this.openCompressionItemsListButton.click();
        logger.info("Clicked on " + openCompressionItemsListButton.getTagName());
        return this;
    }


    @Override
    public ProductPage openPage() {
        driver.navigate().to(productPageUrl);
        logger.info("Opened page " +  productPageUrl);
        return this;
    }

    public ComparisonPage goToCompressionButtonClick(){
        this.goToCompressionButton.click();
        logger.info("Clicked on " + goToCompressionButton.getTagName());
        return new ComparisonPage(driver);
    }

    public ProductPage addToComparison(){
        this.addToComparisonComboBox.click();
        logger.info("Clicked on " + addToComparisonComboBox.getTagName());
        return this;
    }


    public String getProductNameLabelInnerText(){
        return this.productNameLabel.getText();
    }

    public ProductPage addToBookmarksButtonClick(){
        this.addToBookmarksButton.click();
        logger.info("Clicked on " + addToBookmarksButton.getTagName());
        return this;
    }

    public ProductPage bookmarksButtonClick(){
        this.bookmarksButton.click();
        logger.info("Clicked on " + bookmarksButton.getTagName());
        return this;
    }

    public String getInnerTextFromProductInBookmarksLabel(){
        return this.productInBookmarksLabel.getText();
    }

    public MainPage mainLogoClick(){
        this.mainLogo.click();
        logger.info("Clicked on " + mainLogo.getTagName());
        return new MainPage(driver);
    }


}
