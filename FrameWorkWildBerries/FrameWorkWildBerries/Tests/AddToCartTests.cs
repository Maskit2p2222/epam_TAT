using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace FrameWorkWildBerries.Tests
{

    [TestFixture]
    class AddToCartTests : Test
    {


        [Test]
        public void AddToCartTest()
        {
            string productPageUrl = "https://www.wildberries.ru/catalog/10667313/detail.aspx?targetUrl=XS";
            Pages.ProductPage product = new Pages.ProductPage(driver, productPageUrl);
            string productNameOnProductPage = product
                .OpenPage()
                .GetProductNameSpanText();
            string productColorOnProductPage = product
                .GetProductColorSpanText();
            Pages.CartPage cart = product
                .ClickOnAddToCartButton()
                .ClickGoToCartButton();
            string productNameOnCartPage = cart
                .GetProductNameSpanInCart();
            string productColorOnCartPage = cart
                .GetProductColorSpanInCart();


            Assert.That(productNameOnProductPage, Does.Contain(productNameOnCartPage.Substring(0,50)));
            Assert.AreEqual(productColorOnProductPage, productColorOnCartPage);
        }
    }
}
