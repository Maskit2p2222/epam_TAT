package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostNavBarPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='h1 ib']")
    private WebElement postNavBarPageNameLabel;


    public PostNavBarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getPostNavBarPageNameLabelText(){
        return this.postNavBarPageNameLabel.getText();
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException();
    }


}
