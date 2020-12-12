package service;

public class HistoryProductsDataReader {
    private static final String TESTDATA_COUNTS_OF_HISTORY_PRODUCTS = "testdata.countsOfHistoryProducts";

    public static String getCountsOfHistoryProducts(){
        return TestDataReader.getTestData(TESTDATA_COUNTS_OF_HISTORY_PRODUCTS);
    }
}
