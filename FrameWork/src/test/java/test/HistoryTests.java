package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import service.HistoryProductsDataReader;
import service.ProductDataReader;

public class HistoryTests extends CommonConditions {

    @Test
    public void testAddingProductToHistory(){
        String countsOfHistoryProducts = HistoryProductsDataReader.getCountsOfHistoryProducts();
        String xiaomiPageUrl = ProductDataReader.getXiaomiPageUrl();
        String historyLabelText = new ProductPage(driver,xiaomiPageUrl)
                .openPage()
                .mainLogoClick()
                .getCountOfVisitedProductPagesSpan();
        Assert.assertEquals(historyLabelText,countsOfHistoryProducts);
    }

}
