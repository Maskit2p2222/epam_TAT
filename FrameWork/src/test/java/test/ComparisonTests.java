package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import service.ProductDataReader;

import java.util.List;

public class ComparisonTests extends CommonConditions {

    @Test
    public void testComparison(){
        String xiaomiPhonePageUlr = ProductDataReader.getXiaomiPageUrl();
        String samsungPhonePageUrl = ProductDataReader.getSamsungPageUtr();
        ProductPage productPage = new ProductPage(driver, xiaomiPhonePageUlr);
        productPage.openPage().addToComparison();
        List<String> exceptedPhoneNameModels = productPage
                .goToNewPage(samsungPhonePageUrl)
                .addToComparison()
                .openComparisonItemListMenu()
                .getItemsAddedToComparisonText();
        boolean isAllEqual = true;
        String samsungPhoneModelName = ProductDataReader.getSamsungPhoneModel();
        String xiaomiPhoneModelName = ProductDataReader.getXiaomiPhoneModel();
        for (String modelName : exceptedPhoneNameModels) {
            if (!modelName.toLowerCase().contains(samsungPhoneModelName.toLowerCase()) &&
                    !modelName.toLowerCase().contains(xiaomiPhoneModelName.toLowerCase())) {
                isAllEqual = false;
                break;
            }
        }
        Assert.assertTrue(isAllEqual);
    }
}
