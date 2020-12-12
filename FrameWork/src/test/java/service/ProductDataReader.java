package service;

public class ProductDataReader {
    private static final String TESTDATA_XIAOMI_PHONE = "testdata.xiaomi.phone";

    public static String getXiaomiPhoneModel(){
        return TestDataReader.getTestData(TESTDATA_XIAOMI_PHONE);
    }

}
