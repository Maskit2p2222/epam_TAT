package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage
{
	protected WebDriver driver;
	protected static final Logger logger = LogManager.getRootLogger();
	protected abstract AbstractPage openPage();
	protected static final int WAIT_TIMEOUT_SECONDS = 6;
	protected final WebDriverWait driverWait;


	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
		driverWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
	}

}
