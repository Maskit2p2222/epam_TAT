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
            string productPageUrl = Statics.TestStaticValues.ProductPageUrl;
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
