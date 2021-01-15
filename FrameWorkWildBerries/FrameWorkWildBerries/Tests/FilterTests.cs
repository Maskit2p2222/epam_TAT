using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace FrameWorkWildBerries.Tests
{
    [TestFixture]
    class FilterTests : Test
    {


        [Test]
        public void MaxPriceFilterTest()
        {
            string maxPrice = "10000";
            List<int> ProductPrices = new Pages.MainPage(driver)
             .OpenPage()
             .SendSearchQuery("Телефоны samsung")
             .ClickOnSearchButton()
             .SendMaxPrice(maxPrice)
             .GetProductsPrices();

            Assert.That(ProductPrices.Any(p => p <= int.Parse(maxPrice)));
        }

        [Test]
        public void OrderByPriceTest()
        {
            List<int> ProductPrices = new Pages.MainPage(driver)
             .OpenPage()
             .SendSearchQuery("Телефоны samsung")
             .ClickOnSearchButton()
             .ClickOnOrderByPriceButton()
             .GetProductsPrices();

            Assert.AreEqual(ProductPrices, ProductPrices.OrderBy(productPrice => productPrice));
        }

        [Test]
        public void MinPriceFilterTest()
        {
            string minPrice = "1000";
            List<int> ProductPrices = new Pages.MainPage(driver)
             .OpenPage()
             .SendSearchQuery("Телефоны samsung")
             .ClickOnSearchButton()
             .SendMinPrice(minPrice)
             .GetProductsPrices();

            Assert.That(ProductPrices.Any(p => p >= int.Parse(minPrice)));
        }



    }
}
