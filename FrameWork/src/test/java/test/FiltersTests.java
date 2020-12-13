package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;
import service.SearchQueryDataReader;

public class FiltersTests extends CommonConditions {

    @Test
    public void testPriceUnderFilterTest(){
        String searchRow = SearchQueryDataReader.getSearchSamsungQuery();
        String maxPrice = SearchQueryDataReader.getFilterMaxPrice();
        String expectedMaxPrice = new MainPage(driver)
                .openPage()
                .searchForQuery(searchRow)
                .applySpecifiedFilter(maxPrice)
                .getFirstElementPriceLabel().replaceAll("\\s+","");
        Assert.assertTrue(Integer.parseInt(expectedMaxPrice) < Integer.parseInt(maxPrice));

    }

}
