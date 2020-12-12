package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://www.e-katalog.ru/";

	@FindBy(xpath = "//span[@class='wu_entr']")
	private WebElement enterButton;

	@FindBy(xpath = "//div[@class='signin-with signin-with-ek d-flex justify-content-center align-items-center' and @jtype='click']")
	private WebElement enterWithEmailButton;

	@FindBy(xpath = "//input[@class='ek-form-control' and @type='text']")
	private WebElement emailInput;

	@FindBy(xpath = "//input[@class='ek-form-control' and @type='password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[@class='ek-form-btn blue']")
	private WebElement enterButtonInPopUp;

	@FindBy(xpath = "//a[@class='info-nick']")
	private WebElement userNameLabel;

	@FindBy(xpath = "//div[@class='ek-form-text']")
	private WebElement exceptionLoginLabel;

	@FindBy(xpath = "//div[@class='ib h']")
	private WebElement regionChangSpan;

	@FindBy(xpath = "//div[@class='lf-text']")
	private WebElement regionDropdownList;

	@FindBy(xpath = "//a[@class='option']")
	private WebElement regionDropdownListElement;

	@FindBy(xpath = "//div[@class='ib h']/em")
	private WebElement currentRegionEm;

	private final By byRegionDropdownList = By.xpath("//div[@class='lf-text']");

	private final By byEnterWithEmailButton = By.xpath("//div[@class='signin-with signin-with-ek d-flex justify-content-center align-items-center' and @jtype='click']");

	private final By byUserNameLabel = By.xpath("//a[@class='info-nick']");

	private final By byExceptionLoginLabel = By.xpath("//div[@class='ek-form-text']");

	private final By byRegionChangSpan = By.xpath("//div[@class='ib h']");

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getExceptionLoginLabel(){
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions
						.presenceOfElementLocated(byExceptionLoginLabel));
		return exceptionLoginLabel.getText();
	}

	public MainPage clickEnterButton(){
		this.enterButton.click();
		return this;

	}

	public MainPage clickOnRegionChangSpan(){
		new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(byRegionChangSpan));
		this.regionChangSpan.click();
		return this;
	}

	public MainPage changRegion(){
		new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(byRegionDropdownList));
		this.regionDropdownList.click();
		this.regionDropdownListElement.click();
		return this;
	}

	public String getChangingRegion(){
		return this.currentRegionEm.getText();
	}

	public MainPage clickEnterWithEmailButton(){
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions
						.presenceOfElementLocated(byEnterWithEmailButton));
		this.enterWithEmailButton.click();
		return this;
	}

	public MainPage enterLoginDataAndClickEnterButton(User user){
		this.emailInput.sendKeys(user.getUsername());
		this.passwordInput.sendKeys(user.getPassword());
		this.enterButtonInPopUp.click();
		return this;
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}



	public String getLoginName() {
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions
						.presenceOfElementLocated(byUserNameLabel));
		return userNameLabel.getText();
	}

}
