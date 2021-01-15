using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;

namespace FrameWorkWildBerries.Pages
{
    class MainPage : AbstactPage
    {
        private const string BASE_URL = "https://www.wildberries.ru/";

        private IWebElement InputSearchLine => driver.FindElement(By.Id("tbSrch"));

        private IWebElement SearchButton => driver.FindElement(By.Id("btnSrch"));



        private IReadOnlyCollection<IWebElement> VisitedProducts =>
            driver.FindElement(By.ClassName("j-goods-wrapper-visited"))
            .FindElements(By.ClassName("good-name"));
        

        public MainPage(IWebDriver driver) : base(driver) { }

        public MainPage OpenPage()
        {
            driver.Navigate().GoToUrl(BASE_URL);
            return this;
        }

        public List<string> GetNamesOfVisitedProducts()
        {
            return Utils.WebElementParses.ParseWebElemtsToListOfStings(VisitedProducts);
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
