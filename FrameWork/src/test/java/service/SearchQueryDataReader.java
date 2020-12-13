package service;

public class SearchQueryDataReader {

    private static final String TESTDATA_SEARCH_SAMSUNG_QUERY = "testdata.search.samsung.query";
    private static final String TESTDATA_SEARCH_SAMSUNG_RESULT_QUERY = "testdata.search.samsung.query.result";

    private static final String TESTDATA_SEARCH_APPLE_QUERY = "testdata.search.apple.query";
    private static final String TESTDATA_SEARCH_APPLE_RESULT_QUERY = "testdata.search.apple.query.result";

    private static final String TESTDATA_SEARCH_XIAOMI_QUERY = "testdata.search.xiaomi.query";
    private static final String TESTDATA_SEARCH_XIAOMI_RESULT_QUERY = "testdata.search.xiaomi.query.result";

    private static final String TESTDATA_FILTER_MAXPRICE="testdata.filter.maxprice";

    public static String getSearchSamsungQuery(){
        return TestDataReader.getTestData(TESTDATA_SEARCH_SAMSUNG_QUERY);
    }

    public static String getSearchSamsungResultQuery(){
        return TestDataReader.getTestData(TESTDATA_SEARCH_SAMSUNG_RESULT_QUERY);
    }

    public static String getSearchAppleQuery(){
        return TestDataReader.getTestData(TESTDATA_SEARCH_APPLE_QUERY);
    }

    public static String getSearchAppleResultQuery(){
        return TestDataReader.getTestData(TESTDATA_SEARCH_APPLE_RESULT_QUERY);
    }

    public static String getSearchXiaomiQuery(){
        return TestDataReader.getTestData(TESTDATA_SEARCH_XIAOMI_QUERY);
    }

    public static String getSearchXiaomiResultQuery(){
        return TestDataReader.getTestData(TESTDATA_SEARCH_XIAOMI_RESULT_QUERY);
    }


    public static String getFilterMaxPrice(){
        return TestDataReader.getTestData(TESTDATA_FILTER_MAXPRICE);
    }

}
