using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;

namespace FrameWorkWildBerries.Pages
{
    internal abstract class AbstactPage
    {

        protected readonly IWebDriver driver;
        protected readonly int MaxDelaySeconds;

        public AbstactPage (IWebDriver driver)
        {
            this.driver = driver;
            this.MaxDelaySeconds = 10;
        }


    }
}
