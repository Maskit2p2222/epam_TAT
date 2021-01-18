using OpenQA.Selenium;

namespace BDDFrameWorkE_Katalog.Pages
{
    class AbstractPage
    {
        protected readonly IWebDriver driver;
        public AbstractPage(IWebDriver driver)
        {
            this.driver = driver;
        }
    }
}
