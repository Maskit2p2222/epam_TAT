using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;

namespace FrameWorkWildBerries.Pages
{
    class CartPage : AbstactPage
    {

        private const string BASE_URL = "https://www.wildberries.ru/lk/basket";

        private IWebElement ProductColorSpanInCart => driver.FindElement(By.ClassName("color-item"));
        private IWebElement ProductNameSpanInCart => driver.FindElement(By.ClassName("good-name"));

        public CartPage(IWebDriver driver) : base(driver)
        {
        }

        public string GetProductColorSpanInCart()
        {
            return ProductColorSpanInCart.Text;
        }

        public string GetProductNameSpanInCart()
        {
            return ProductNameSpanInCart.Text;
        }


        public CartPage OpenPage()
        {
            driver.Navigate().GoToUrl(BASE_URL);
            return this;
        }
    }
}
