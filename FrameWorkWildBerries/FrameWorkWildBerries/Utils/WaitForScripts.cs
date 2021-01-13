using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace FrameWorkWildBerries.Utils
{
    public class WaitForScripts
    {

        public static void WaitForJqueryAjax(IWebDriver driver, int MaxdelaySeconds)
        {
            int delay = MaxdelaySeconds;
            while (delay > 0)
            {
                Thread.Sleep(100);
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
                delay--;
            }
        }
    }
}
