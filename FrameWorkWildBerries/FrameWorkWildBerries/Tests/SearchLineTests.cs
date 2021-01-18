using NUnit.Framework;
using System.Collections.Generic;
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
                .SendSearchQuery(Statics.TestStaticValues.SearchQuery)
                .ClickOnSearchButton()
                .GetMainLabelPageText();
            Assert.That(productsNames.Any(p => p.ToLower().Contains(Statics.TestStaticValues.ModelName)));
        }

        [Test]
        public void WrondSearchLineTest()
        {
            List<string> productsNames = new Pages.MainPage(driver)
                .OpenPage()
                .SendSearchQuery(Statics.TestStaticValues.WrongSearchQuery)
                .ClickOnSearchButton()
                .GetMainLabelPageText();
            Assert.That(productsNames.Any(p => p.ToLower().Contains(Statics.TestStaticValues.ModelName)));
        }

    }
}
