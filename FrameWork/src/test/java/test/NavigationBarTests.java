package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;
import service.SearchQueryDataReader;

import java.util.List;

public class NavigationBarTests extends CommonConditions {

    @Test
    public void testPhoneNavigationBar() {
        MainPage mainPage = new MainPage(driver);
        String subNavBarLinkText = mainPage
                .openPage()
                .clickOnNavBarFirstLinkButton()
                .getSubNavBarFirstLinkButtonText();
        String extendedMainPageNameLabel = mainPage
                .clickOnSubNavBarFirstLinkButton()
                .getPostNavBarPageNameLabelText();
        Assert.assertTrue(extendedMainPageNameLabel.toLowerCase()
                .contains(subNavBarLinkText.toLowerCase()));

    }


}
