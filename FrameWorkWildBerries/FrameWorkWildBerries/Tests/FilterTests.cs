﻿using NUnit.Framework;
using System.Collections.Generic;
using System.Linq;

namespace FrameWorkWildBerries.Tests
{
    [TestFixture]
    class FilterTests : Test
    {


        [Test]
        public void MaxPriceFilterTest()
        {
            string maxPrice = Statics.TestStaticValues.MaxPrice;
            List<int> ProductPrices = new Pages.MainPage(driver)
             .OpenPage()
             .SendSearchQuery(Statics.TestStaticValues.SearchQuery)
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
             .SendSearchQuery(Statics.TestStaticValues.SearchQuery)
             .ClickOnSearchButton()
             .ClickOnOrderByPriceButton()
             .GetProductsPrices();

            Assert.AreEqual(ProductPrices, ProductPrices.OrderBy(productPrice => productPrice));
        }

        [Test]
        public void MinPriceFilterTest()
        {
            string minPrice = Statics.TestStaticValues.MinPrice;
            List<int> ProductPrices = new Pages.MainPage(driver)
             .OpenPage()
             .SendSearchQuery(Statics.TestStaticValues.SearchQuery)
             .ClickOnSearchButton()
             .SendMinPrice(minPrice)
             .GetProductsPrices();

            Assert.That(ProductPrices.Any(p => p >= int.Parse(minPrice)));
        }



    }
}
