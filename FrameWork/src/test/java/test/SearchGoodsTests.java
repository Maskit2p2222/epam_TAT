package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;
import service.SearchQueryDataReader;

public class SearchGoodsTests extends CommonConditions{

    @Test
    public void testSearchForGoodsSamsung() {
        String searchRow = SearchQueryDataReader.getSearchQuery();
        String resultRow = SearchQueryDataReader.getSearchResultQuery();
        String firstElementName = new MainPage(driver)
                .openPage()
                .searchForQuery(searchRow)
                .getFirstElementName();
        Assert.assertTrue(firstElementName.toLowerCase().contains(resultRow));
    }

}
