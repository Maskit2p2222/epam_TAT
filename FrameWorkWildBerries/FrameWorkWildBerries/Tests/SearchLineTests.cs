using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;

namespace FrameWorkWildBerries.Tests
{
    [TestFixture]
    class SearchLineTests : Test
    {
        [Test]
        public void SearchLineTest()
        {
            List<string> productsNames = new Pages.MainPage(driver)
                .OpenPage()
                .SendSearchQuery("Телефоны Samsung")
                .ClickOnSearchButton()
                .GetMainLabelPageText();
            Assert.That(productsNames.Any(p => p.ToLower().Contains("samsung")));
        }

        [Test]
        public void WrondSearchLineTest()
        {
            List<string> productsNames = new Pages.MainPage(driver)
                .OpenPage()
                .SendSearchQuery("ntktajys samsung")
                .ClickOnSearchButton()
                .GetMainLabelPageText();
            Assert.That(productsNames.Any(p => p.ToLower().Contains("samsung")));
        }

    }
}
