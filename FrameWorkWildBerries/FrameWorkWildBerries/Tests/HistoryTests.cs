using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace FrameWorkWildBerries.Tests
{

    [TestFixture]
    class HistoryTests : Test
    {

        [Test]
        public void HistoryTest()
        {
            string FirstProductPageUrl = "https://www.wildberries.ru/catalog/10667313/detail.aspx?targetUrl=XS";
            string SecondProductPageUrl = "https://www.wildberries.ru/catalog/14098359/detail.aspx?targetUrl=BP";
            Pages.ProductPage productPage = new Pages.ProductPage(driver, FirstProductPageUrl);

            string NameOfFirstProduct = productPage
                .OpenPage()
                .GetProductNameSpanText();
            productPage = new Pages.ProductPage(driver, SecondProductPageUrl);
            string NameOfSecondProduct = productPage
                .OpenPage()
                .GetProductNameSpanText();
            List<string> NamesOfFirstProductsInHistory = productPage
                .ClickOnHeaderLogo()
                .GetNamesOfVisitedProducts();

            Assert.That(NameOfSecondProduct, Does
                .Contain(NamesOfFirstProductsInHistory[0].Substring(0, 20)));
            Assert.That(NameOfFirstProduct, Does
                .Contain(NamesOfFirstProductsInHistory[1].Substring(0, 20)));
        }

    }
}
