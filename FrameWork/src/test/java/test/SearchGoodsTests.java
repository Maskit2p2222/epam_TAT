package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;
import service.SearchQueryDataReader;

import java.util.List;

public class SearchGoodsTests extends CommonConditions{

    @Test
    public void testSearchForGoodsSamsung() {
        String searchRow = SearchQueryDataReader.getSearchSamsungQuery();
        String resultRow = SearchQueryDataReader.getSearchSamsungResultQuery();
        List<String> allElementsName = new MainPage(driver)
                .openPage()
                .searchForQuery(searchRow)
                .getAllElementsName();
        for (String elementName:
                allElementsName) {
            Assert.assertTrue(elementName.toLowerCase().contains(resultRow));
        }
    }

    @Test
    public void testSearchForGoodsApple() {
        String searchRow = SearchQueryDataReader.getSearchAppleQuery();
        String resultRow = SearchQueryDataReader.getSearchAppleResultQuery();
        List<String> allElementsName = new MainPage(driver)
                .openPage()
                .searchForQuery(searchRow)
                .getAllElementsName();
        for (String elementName:
                allElementsName) {
            Assert.assertTrue(elementName.toLowerCase().contains(resultRow));
        }
    }

    @Test
    public void testSearchForGoodsXiaomi() {
        String searchRow = SearchQueryDataReader.getSearchXiaomiQuery();
        String resultRow = SearchQueryDataReader.getSearchXiaomiResultQuery();
        List<String> allElementsName = new MainPage(driver)
                .openPage()
                .searchForQuery(searchRow)
                .getAllElementsName();
        for (String elementName:
                allElementsName) {
            Assert.assertTrue(elementName.toLowerCase().contains(resultRow));
        }
    }

}
