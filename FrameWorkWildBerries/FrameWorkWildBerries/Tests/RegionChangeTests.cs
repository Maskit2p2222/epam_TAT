using NUnit.Framework;

namespace FrameWorkWildBerries.Tests
{
    [TestFixture]
    class RegionChangeTests : Test
    {

        [Test]
        public void ChangeRegionFromMoscowToSanPeterburg()
        {
            string productPageUrl = Statics.TestStaticValues.ProductPageUrl;
            Pages.ProductPage product = new Pages.ProductPage(driver, productPageUrl);
            string currentRegionOnNavBar = product
                .OpenPage()
                .ClickOnChangeRegionSpan()
                .ChangeRegion(Statics.TestStaticValues.RegionName)
                .GetCurrentRegionFromNavBar();
            string currentRegionOnProductPage = product
                .GetCurrentRegionFromProductPage();

            Assert.AreEqual(currentRegionOnNavBar, currentRegionOnProductPage, Statics.TestStaticValues.RegionName);
        }

    }
}
