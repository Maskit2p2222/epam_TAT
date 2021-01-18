using OpenQA.Selenium;

namespace BDDFrameWorkE_Katalog.Steps
{
    public class Steps
    {
        protected IWebDriver driver;

        public void InitBrowser()
        {
            driver = Driver.DriverInstance.GetInstance();
        }

        public void CloseBrowser()
        {
            Driver.DriverInstance.CloseBrowser();
        }

    }
}
