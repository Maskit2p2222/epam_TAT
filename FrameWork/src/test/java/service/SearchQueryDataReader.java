package service;

public class SearchQueryDataReader {

    private static final String TESTDATA_SEARCH_QUERY = "testdata.search.query";
    private static final String TESTDATA_SEARCH_RESULT_QUERY = "testdata.search.query.result";

    public static String getSearchQuery(){
        return TestDataReader.getTestData(TESTDATA_SEARCH_QUERY);
    }

    public static String getSearchResultQuery(){
        return TestDataReader.getTestData(TESTDATA_SEARCH_RESULT_QUERY);
    }

}
