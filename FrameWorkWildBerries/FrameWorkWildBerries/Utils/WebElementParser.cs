using OpenQA.Selenium;
using System.Collections.Generic;
using System.Linq;

namespace FrameWorkWildBerries.Utils
{
    public class WebElementParser
    {

        public static List<string> ParseWebElemtsToListOfStings(IReadOnlyCollection<IWebElement> webElements)
        {
            List<string> webElemntsInnerTexts = new List<string>();
            foreach(var element in webElements)
            {
                webElemntsInnerTexts.Add(element.Text);
            }

            return webElemntsInnerTexts;
        }

        public static List<int> ParseListOfStringsToListOfInts(List<string> strings)
        {
            List<int> intPrices = new List<int>();
            foreach(var line in strings){
                int.TryParse(string.Join("", line.Where(c => char.IsDigit(c))), out int value);
                intPrices.Add(value);
            }

            return intPrices;
        }

    }
}
