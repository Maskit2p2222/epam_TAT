package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;
import service.SearchQueryDataReader;

public class SearchGoodsTests extends CommonConditions{

    @Test
    public void testSearchForGoodsSamsung() {
        String searchRow = SearchQueryDataReader.getSearchSamsungQuery();
        String resultRow = SearchQueryDataReader.getSearchSamsungResultQuery();
        String firstElementName = new MainPage(driver)
                .openPage()
                .searchForQuery(searchRow)
                .getFirstElementName();
        Assert.assertTrue(firstElementName.toLowerCase().contains(resultRow));
    }

    @Test
    public void testSearchForGoodsApple() {
        String searchRow = SearchQueryDataReader.getSearchAppleQuery();
        String resultRow = SearchQueryDataReader.getSearchAppleResultQuery();
        String firstElementName = new MainPage(driver)
                .openPage()
                .searchForQuery(searchRow)
                .getFirstElementName();
        Assert.assertTrue(firstElementName.toLowerCase().contains(resultRow));
    }

    @Test
    public void testSearchForGoodsXiaomi() {
        String searchRow = SearchQueryDataReader.getSearchXiaomiQuery();
        String resultRow = SearchQueryDataReader.getSearchXiaomiResultQuery();
        String firstElementName = new MainPage(driver)
                .openPage()
                .searchForQuery(searchRow)
                .getFirstElementName();
        Assert.assertTrue(firstElementName.toLowerCase().contains(resultRow));
    }

}
