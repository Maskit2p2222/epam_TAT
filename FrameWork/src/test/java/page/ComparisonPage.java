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

public class ComparisonPage extends  AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@href='/XIAOMI-REDMI-NOTE-8-PRO-128GB-6GB.htm']")
    private WebElement xiaomiNameLabel;

    private final By bySamsungNameLabel = By.xpath("//a[@data-idgood='1723266'");


    public ComparisonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getSamsungNameLabelText(){
        logger.info("Returned Samsung model");
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(bySamsungNameLabel)).getText();
    }

    public String getXiaomiNameLabelText(){
        logger.info("Returned Xiaomi model");
        return this.xiaomiNameLabel.getText();
    }

    @Override
    public AbstractPage openPage() {
        return null;
    }
}
