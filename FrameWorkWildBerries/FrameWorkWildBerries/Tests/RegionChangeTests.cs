using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace FrameWorkWildBerries.Tests
{
    [TestFixture]
    class RegionChangeTests : Test
    {

        [Test]
        public void ChangeRegionFromMoscowToSanPeterburg()
        {
            string productPageUrl = "https://www.wildberries.ru/catalog/10667313/detail.aspx?targetUrl=XS";
            Pages.ProductPage product = new Pages.ProductPage(driver, productPageUrl);
            string currentRegionOnNavBar = product
                .OpenPage()
                .ClickOnChangeRegionSpan()
                .ChangeRegion("Санкт-Петербург")
                .GetCurrentRegionFromNavBar();
            string currentRegionOnProductPage = product
                .GetCurrentRegionFromProductPage();

            Assert.AreEqual(currentRegionOnNavBar, currentRegionOnProductPage, "Санкт-Петербург");
        }

    }
}
