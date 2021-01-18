using NUnit.Framework;
using OpenQA.Selenium;

namespace FrameWorkWildBerries.Tests
{
    [TestFixture]
    public abstract class Test
    {
        protected IWebDriver driver;
        [SetUp]
        public void Init()
        {
            driver = Driver.DriverInstance.GetInstance();
        }

        [TearDown]
        public void Cleanup()
        {
            Driver.DriverInstance.CloseBrowser();
        }
    }
}
