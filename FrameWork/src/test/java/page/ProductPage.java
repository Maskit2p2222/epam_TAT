package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPage {

    private final String PRODUCT_PAGE_URL = "https://www.e-katalog.ru/XIAOMI-REDMI-NOTE-8-PRO-128GB-6GB.htm";

    @FindBy(xpath = "//h1[@class='t2 no-mobile']/b[@class='ib']")
    private WebElement productNameLabel;

    @FindBy(xpath = "//span[@class='addto-wishlist heart-empty heart_1644502']")
    private WebElement addToBookmarksButton;

    @FindBy(id="name_bm_marked")
    private WebElement bookmarksButton;

    @FindBy(xpath = "//div[@class='side-list-label ']")
    private WebElement productInBookmarksLabel;

    @FindBy(xpath = "//div[@class='header']/*/*/div[@class='header_logo']/a[@href='https://www.e-katalog.ru/']")
    private WebElement mainLogo;


    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }



    @Override
    public ProductPage openPage() {
        driver.navigate().to(PRODUCT_PAGE_URL);
        return this;
    }


    public String getProductNameLabelInnerText(){
        return this.productNameLabel.getText();
    }

    public ProductPage addToBookmarksButtonClick(){
        this.addToBookmarksButton.click();
        return this;
    }

    public ProductPage bookmarksButtonClick(){
        this.bookmarksButton.click();
        return this;
    }

    public String getInnerTextFromProductInBookmarksLabel(){
        return this.productInBookmarksLabel.getText();
    }

    public MainPage mainLogoClick(){
        this.mainLogo.click();
        return new MainPage(driver);
    }


}
