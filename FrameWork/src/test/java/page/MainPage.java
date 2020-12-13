package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://www.e-katalog.ru/";

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

	public String getCountOfVisitedProductPagesSpan(){
		return this.countOfVisitedProductPagesSpan.getText();
	}

	public String getExceptionLoginLabel(){
		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions
						.presenceOfElementLocated(byExceptionLoginLabel)).getText();
	}

	public MainPage clickEnterButton(){
		logger.info("Clicked on " + enterButton.getTagName());
		this.enterButton.click();
		return this;

	}

	public MainPage clickOnRegionChangSpan(){
		new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(byRegionChangSpan)).click();
		return this;
	}

	public MainPage changRegion(){
		new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(byRegionDropdownList)).click();
		logger.info("Clicked on Region dropdown list");
		this.regionDropdownListElement.click();
		logger.info("Clicked on " + regionDropdownListElement.getTagName());
		return this;
	}

	public String getChangingRegion(){
		return this.currentRegionEm.getText();
	}

	public MainPage clickEnterWithEmailButton(){
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions
						.presenceOfElementLocated(byEnterWithEmailButton)).click();
		logger.info("Clicked on email button in login");
		return this;
	}

	public MainPage enterLoginDataAndClickEnterButton(User user){
		this.emailInput.sendKeys(user.getUsername());
		logger.info("Send into " + emailInput.getTagName() +" key - " + user.getUsername());
		this.passwordInput.sendKeys(user.getPassword());
		logger.info("Send into " + passwordInput.getTagName() +" key - " + user.getPassword());
		this.enterButtonInPopUp.click();
		logger.info("Clicked on " + enterButtonInPopUp.getTagName());
		return this;
	}

	public String getLoginName() {
		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions
						.presenceOfElementLocated(byUserNameLabel)).getText();
	}

}
