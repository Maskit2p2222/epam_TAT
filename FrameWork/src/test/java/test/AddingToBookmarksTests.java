package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import service.ProductDataReader;

public class AddingToBookmarksTests extends CommonConditions  {

    @Test
    public void testAddXiaomiPhoneToBookmarks(){
        String xiaomiPhoneModel = ProductDataReader.getXiaomiPhoneModel();
        String xiaomiPageUrl = ProductDataReader.getXiaomiPageUrl();
        ProductPage xiaomiPage = new ProductPage(driver,xiaomiPageUrl);
        String xiaomiNameText = xiaomiPage
                .openPage()
                .getProductNameLabelInnerText();
        String expectedXiaomiNameText = xiaomiPage
                .addToBookmarksButtonClick()
                .bookmarksButtonClick()
                .getInnerTextFromProductInBookmarksLabel();

        Assert.assertTrue(expectedXiaomiNameText.contains(xiaomiPhoneModel) && xiaomiNameText.contains(xiaomiPhoneModel));
    }

}
