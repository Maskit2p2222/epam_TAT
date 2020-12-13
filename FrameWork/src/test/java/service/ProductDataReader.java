package service;

public class ProductDataReader {
    private static final String TESTDATA_XIAOMI_PHONE = "testdata.xiaomi.phone";
    private static final String TESTDATA_XIAOMI_PAGE = "testdata.xiaomi.page";
    private static final String TESTDATA_SAMSUNG_PAGE = "testdata.samsung.page";
    private static final String TESTDATA_SAMSUNG_PHONE = "testdata.samsung.phone";

    public static String getXiaomiPhoneModel(){
        return TestDataReader.getTestData(TESTDATA_XIAOMI_PHONE);
    }

    public static String getXiaomiPageUrl(){
        return TestDataReader.getTestData(TESTDATA_XIAOMI_PAGE);
    }

    public static String getSamsungPageUtr() { return TestDataReader.getTestData(TESTDATA_SAMSUNG_PAGE);}

    public static String getSamsungPhoneModel() { return TestDataReader.getTestData(TESTDATA_SAMSUNG_PHONE) ;}



}
