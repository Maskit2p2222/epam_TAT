using NUnit.Framework;
using System.Collections.Generic;

namespace FrameWorkWildBerries.Tests
{

    [TestFixture]
    class HistoryTests : Test
    {

        [Test]
        public void HistoryTest()
        {
            string FirstProductPageUrl = Statics.TestStaticValues.ProductPageUrl;
            string SecondProductPageUrl = Statics.TestStaticValues.AlternativeProductPageUrl;
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
