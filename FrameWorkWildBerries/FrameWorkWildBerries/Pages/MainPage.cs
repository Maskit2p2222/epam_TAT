using OpenQA.Selenium;
using System.Collections.Generic;

namespace FrameWorkWildBerries.Pages
{
    class MainPage : AbstactPage
    {
        private const string _baseUrl = "https://www.wildberries.ru/";

        private IWebElement InputSearchLine => driver.FindElement(By.Id("tbSrch"));

        private IWebElement SearchButton => driver.FindElement(By.Id("btnSrch"));



        private IReadOnlyCollection<IWebElement> VisitedProducts =>
            driver.FindElement(By.ClassName("j-goods-wrapper-visited"))
            .FindElements(By.ClassName("good-name"));
        

        public MainPage(IWebDriver driver) : base(driver) { }

        public MainPage OpenPage()
        {
            driver.Navigate().GoToUrl(_baseUrl);
            return this;
        }

        public List<string> GetNamesOfVisitedProducts()
        {
            return Utils.WebElementParser.ParseWebElemtsToListOfStings(VisitedProducts);
        }

        public MainPage SendSearchQuery(string searchQuery)
        {
            InputSearchLine.SendKeys(searchQuery);
            return this;
        }


        public SearchResultPage ClickOnSearchButton()
        {
            SearchButton.Click();
            return new SearchResultPage(driver);
        }

    }
}
