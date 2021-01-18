using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;

namespace BDDFrameWorkE_Katalog.Pages
{
    class AbstractPage
    {
        protected readonly IWebDriver driver;
        public AbstractPage(IWebDriver driver)
        {
            this.driver = driver;
        }
    }
}
