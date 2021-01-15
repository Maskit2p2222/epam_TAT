using OpenQA.Selenium;
using System.Collections.Generic;
using System.Threading;

namespace FrameWorkWildBerries.Pages
{
    internal class SearchResultPage : AbstactPage
    {
        private const string BASE_URL = "https://www.e-katalog.ru/";


        private IReadOnlyCollection<IWebElement> ProductsWebElemets => 
            driver.FindElements(By.XPath("//strong[@class='brand-name c-text-sm']"));

        private IReadOnlyCollection<IWebElement> ProductsPrices =>
            driver.FindElements(By.ClassName("lower-price"));
        private IWebElement MaxPriceInput => driver.FindElement(By.ClassName("end-n"))
            .FindElement(By.ClassName("c-input-base-sm"));

        private IWebElement MinPriceInput => driver.FindElement(By.ClassName("start-n"))
            .FindElement(By.ClassName("c-input-base-sm"));

        private IWebElement OrderByPriceButton => driver.FindElement(By.Id("price"));

        public SearchResultPage(IWebDriver driver) : base(driver) { }

        public SearchResultPage OpenPage()
        {
            driver.Navigate().GoToUrl(BASE_URL);
            return this;
        }

        public SearchResultPage SendMaxPrice(string maxPrice)
        {
            MaxPriceInput.SendKeys(Keys.Control + "a");
            MaxPriceInput.SendKeys(Keys.Delete);
            MaxPriceInput.SendKeys(maxPrice);
            MaxPriceInput.SendKeys(Keys.Enter);
            Utils.WaitForScripts.WaitForJqueryAjax(driver,
                                       MaxDelaySeconds);
            return this;
        }

        public SearchResultPage ClickOnOrderByPriceButton()
        {
            OrderByPriceButton.Click();
            Utils.WaitForScripts.WaitForJqueryAjax(driver,
                                       MaxDelaySeconds);
            return this;
        }

        public SearchResultPage SendMinPrice(string minPrice)
        {
            MinPriceInput.SendKeys(Keys.Control + "a");
            MinPriceInput.SendKeys(Keys.Delete);
            MinPriceInput.SendKeys(minPrice);
            MinPriceInput.SendKeys(Keys.Enter);
            Utils.WaitForScripts.WaitForJqueryAjax(driver,
                                       MaxDelaySeconds);
            return this;
        }

        public List<int> GetProductsPrices()
        {
            return Utils.WebElementParses.ParseListOfStringsToListOfInts(
                    Utils.WebElementParses.ParseWebElemtsToListOfStings(ProductsPrices)
                );
        }

        public List<string> GetMainLabelPageText()
        {
            return Utils.WebElementParses.ParseWebElemtsToListOfStings(ProductsWebElemets);
        }

    }
}