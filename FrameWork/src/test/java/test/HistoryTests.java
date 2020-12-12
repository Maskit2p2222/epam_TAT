package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import service.HistoryProductsDataReader;

public class HistoryTests extends CommonConditions {

    @Test
    public void testAddingProductToHistory(){
        String countsOfHistoryProducts = HistoryProductsDataReader.getCountsOfHistoryProducts();
        String historyLabelText = new ProductPage(driver)
                .openPage()
                .mainLogoClick()
                .getCountOfVisitedProductPagesSpan();
        Assert.assertEquals(historyLabelText,countsOfHistoryProducts);
    }

}
