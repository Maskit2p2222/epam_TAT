using NUnit.Framework;
using TechTalk.SpecFlow;
using TechTalk.SpecFlow.Assist;

namespace BDDFrameWorkE_Katalog.Steps
{
    [Binding]
    public class LoginSteps : Steps
    {
        Pages.MainPage mainPage;

        [Before]
        private void BeforeTests()
        {
            InitBrowser();
        }

        [After]
        private void AfterTests()
        {
            CloseBrowser();
        }

        [Given(@"I launch the application")]
        public void GivenILaunchTheApplication()
        {
            mainPage = new Pages.MainPage(driver);
            mainPage.OpenPage();
        }
        
        [Given(@"I click login button")]
        public void GivenIClickLoginButton()
        {
            mainPage.ClickOnLoginButton();
        }
        
        [Given(@"I click email login button")]
        public void GivenIClickEmailLoginButton()
        {
            mainPage.ClickOnEmailLoginButton();
        }
        
        [Given(@"I enter login information")]
        public void GivenIEnterLoginInformation(Table table)
        {
            dynamic credentials = table.CreateDynamicInstance();
            mainPage.SendLoginInformation(credentials.UserName as string, credentials.Password as string);
        }
        
        [When(@"I click login button")]
        public void WhenIClickLoginButton()
        {
            mainPage.ClickOnEnterButton();
        }
        
        [Then(@"I should see userName near logout button")]
        public void ThenIShouldSeeUserNameNearLogoutButton()
        {
            Assert.That(mainPage.IsProfileButtonDisplayed(), Is.True);
        }

        [Then(@"I should see error message")]
        public void ThenIShouldSeeErrorMessage()
        {
            Assert.That(mainPage.IsErrorMessageDisplayed(), Is.True);
        }

    }
}
