using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;

namespace FrameWorkWildBerries.Pages
{
    class ProductPage : AbstactPage
    {
        private readonly string _currentUrl;


        private IWebElement ProductColorSpan => driver.FindElement(By.ClassName("color"));
        private IWebElement ProductNameSpan => driver.FindElement(By.ClassName("brand-and-name"));
        private IWebElement GoToCartButton => driver.FindElement(By.ClassName("my-basket"));
        private IWebElement AddToCartButton => driver.FindElement(By.ClassName("c-btn-main-lg-v1"));
        private IWebElement ChangeRegionSpan => driver.FindElement(By.ClassName("j-geocity-text"));
        private IWebElement CurrentRegionOnProductPage => driver.FindElement(By.ClassName("delivery-cond-locality"));
        private IWebElement HeaderLogo => driver.FindElement(By.ClassName("header-logo"));

        public ProductPage(IWebDriver driver, string productPageUrl) : base(driver)
        {
            _currentUrl = productPageUrl;
        }

        public string GetCurrentRegionFromProductPage()
        {
            return CurrentRegionOnProductPage.Text;
        }

        public string GetProductNameSpanText()
        {
            return ProductNameSpan.Text;
        }

        public MainPage ClickOnHeaderLogo()
        {
            HeaderLogo.Click();
            return new MainPage(driver);
        }
        
        public string GetProductColorSpanText()
        {
            return ProductColorSpan.Text;
        }

        public ProductPage ClickOnChangeRegionSpan()
        {
            ChangeRegionSpan.Click();
            return this;
        }
        public string GetCurrentRegionFromNavBar()
        {
            return ChangeRegionSpan.Text;
        }


        public ProductPage ChangeRegion(string region)
        {
            IWebElement regionWebElement = driver.FindElement(
                By.XPath($"//li[@class='geocity-pop-item']/span[text()='{region}']")
            );
            regionWebElement.Click();
            Utils.WaitForScripts.WaitForJqueryAjax(driver,
                           MaxDelaySeconds);
            return this;

        }

        public ProductPage ClickOnAddToCartButton()
        {
            AddToCartButton.Click();
            return this;
        }

        public CartPage ClickGoToCartButton()
        {
            GoToCartButton.Click();
            return new CartPage(driver);
        }

        public ProductPage OpenPage()
        {
            driver.Navigate().GoToUrl(_currentUrl);
            return this;
        }
    }
}
