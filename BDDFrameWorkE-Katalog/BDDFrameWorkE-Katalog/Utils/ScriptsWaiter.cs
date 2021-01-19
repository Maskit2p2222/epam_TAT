using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace BDDFrameWorkE_Katalog.Utils
{
    public class ScriptsWaiter
    {
        public static void WaitForJqueryAjax(IWebDriver driver, int MaxdelaySeconds)
        {
            int delay = MaxdelaySeconds;
            while (true)
            {
                var jquery = (bool)(driver as IJavaScriptExecutor)
                    .ExecuteScript("return window.jQuery == undefined");
                if (jquery)
                {
                    break;
                }
                var ajaxIsComplete = (bool)(driver as IJavaScriptExecutor)
                    .ExecuteScript("return window.jQuery.active == 0");
                if (ajaxIsComplete)
                {
                    break;
                }
            }
        }
    }
}
