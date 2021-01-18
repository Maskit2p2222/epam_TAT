using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;

namespace BDDFrameWorkE_Katalog.Pages
{
    class MainPage : AbstractPage
    {
        private const string _baseUrl = "https://www.e-katalog.ru/";

        private IWebElement LoginButton => driver.FindElement(By.ClassName("wu_entr"));

        private IWebElement ProfileButton => driver.FindElement(By.Id("mui_user_login_row"));
        private IWebElement EmailLoginButton => driver
            .FindElement(By
            .ClassName("signin-with-ek"));

        private IWebElement LoginInput => driver.FindElement(By.ClassName("signin-name"))
            .FindElement(By.ClassName("ek-form-control"));
        private IWebElement PasswordInput => driver.FindElement(By.ClassName("signin-password"))
            .FindElement(By.ClassName("ek-form-control"));
        private IWebElement EnterButton => driver
           .FindElements(By
           .ClassName("ek-form-btn"))[1];

        public bool IsProfileButtonDisplayed() => ProfileButton.Displayed;

        public MainPage(IWebDriver driver) : base(driver) { }

        public void ClickOnLoginButton() => LoginButton.Click();
        public void ClickOnEnterButton() => EnterButton.Click();
        public void ClickOnEmailLoginButton() => EmailLoginButton.Click();
        public void SendLoginInformation(string login, string password)
        {
            LoginInput.SendKeys(login);
            PasswordInput.SendKeys(password);
        }

        public void OpenPage()
        {
            driver.Navigate().GoToUrl(_baseUrl);
        }
    }
}
