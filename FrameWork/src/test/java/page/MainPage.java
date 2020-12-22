package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage
{

	private static final String BASE_URL = "https://www.e-katalog.ru/";

	@FindBy(id = "ek-search")
	private WebElement searchLine;

	@FindBy(id = "num_bm_visited")
	private WebElement countOfVisitedProductPagesSpan;

	@FindBy(xpath = "//button[@name='search_but_']")
	private WebElement searchButton;

	@FindBy(xpath = "//span[@class='wu_entr']")
	private WebElement enterButton;

	@FindBy(xpath = "//input[@class='ek-form-control' and @type='text']")
	private WebElement emailInput;

	@FindBy(xpath = "//input[@class='ek-form-control' and @type='password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[@class='ek-form-btn blue']")
	private WebElement enterButtonInPopUp;

	@FindBy(xpath = "//a[@class='option']")
	private WebElement regionDropdownListElement;

	@FindBy(xpath = "//div[@class='ib h']/em")
	private WebElement currentRegionEm;

	@FindBy(xpath = "//img[@src='/img/one-pixel-ico.gif']")
	private WebElement subNavBarFirstLinkButton;

	private static final By byRegionDropdownList = By.xpath("//div[@class='lf-text']");

	private static final By byEnterWithEmailButton =
			By.xpath("//div[@class='signin-with signin-with-ek d-flex justify-content-center align-items-center' and @jtype='click']");

	private static final By byUserNameLabel = By.xpath("//a[@class='info-nick']");

	private static final By byExceptionLoginLabel = By.xpath("//div[@class='ek-form-text']");

	private static final By byRegionChangSpan = By.xpath("//div[@class='ib h']");

	private static final By byNavBarFirstLinkButton = By.xpath("//li[@class='mainmenu-item']");

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Opened page " + BASE_URL);
		return this;
	}

	public QueryResultsPage searchForQuery(String query){
		searchLine.sendKeys(query);
		logger.info("Send into " + searchLine.getTagName() +" key - " + query);
		searchButton.click();
		logger.info("Clicked on " + searchButton.getTagName());
		return new QueryResultsPage(driver);
	}

	public MainPage clickOnNavBarFirstLinkButton(){
		logger.info("Clicked on " + byNavBarFirstLinkButton.toString());
		driverWait.until(ExpectedConditions
				.presenceOfElementLocated(byNavBarFirstLinkButton)).click();
		return this;
	}

	public PostNavBarPage clickOnSubNavBarFirstLinkButton(){
		logger.info("Clicked on " + subNavBarFirstLinkButton.getTagName());
		this.subNavBarFirstLinkButton.click();
		return new PostNavBarPage(driver);
	}

	public String getSubNavBarFirstLinkButtonText(){
		return this.subNavBarFirstLinkButton.getText();
	}

	public String getCountOfVisitedProductPagesSpan(){
		return this.countOfVisitedProductPagesSpan.getText();
	}

	public String getExceptionLoginLabel(){
		return driverWait.until(ExpectedConditions
						.presenceOfElementLocated(byExceptionLoginLabel)).getText();
	}

	public MainPage clickEnterButton(){
		logger.info("Clicked on " + enterButton.getTagName());
		this.enterButton.click();
		return this;

	}

	public MainPage clickOnRegionChangSpan(){
		driverWait.until(ExpectedConditions.presenceOfElementLocated(byRegionChangSpan))
				.click();
		return this;
	}

	public MainPage changRegion(){
		logger.info("Clicked on Region dropdown list");
		driverWait.until(ExpectedConditions.presenceOfElementLocated(byRegionDropdownList))
				.click();
		logger.info("Clicked on " + regionDropdownListElement.getTagName());
		this.regionDropdownListElement.click();
		return this;
	}

	public String getChangingRegion(){
		return this.currentRegionEm.getText();
	}

	public MainPage clickEnterWithEmailButton(){
		logger.info("Clicked on email button in login");
		driverWait.until(ExpectedConditions
				.presenceOfElementLocated(byEnterWithEmailButton)).click();
		return this;
	}

	public MainPage enterLoginDataAndClickEnterButton(User user){
		logger.info("Send into " + emailInput.getTagName() +" key - " + user.getUsername());
		this.emailInput.sendKeys(user.getUsername());
		logger.info("Send into " + passwordInput.getTagName() +" key - " + user.getPassword());
		this.passwordInput.sendKeys(user.getPassword());
		logger.info("Clicked on " + enterButtonInPopUp.getTagName());
		this.enterButtonInPopUp.click();
		return this;
	}

	public String getLoginName() {
		return driverWait.until(ExpectedConditions
						.presenceOfElementLocated(byUserNameLabel)).getText();
	}

}
