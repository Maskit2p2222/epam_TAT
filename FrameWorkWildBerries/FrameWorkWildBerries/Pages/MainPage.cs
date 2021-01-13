﻿using OpenQA.Selenium;
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



        public MainPage(IWebDriver driver) : base(driver) { }

        public MainPage OpenPage()
        {
            driver.Navigate().GoToUrl(BASE_URL);
            return this;
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
