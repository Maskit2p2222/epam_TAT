package com.epam.ta.service;

public class RegionDataReader {

    private static final String TESTDATA_REGION_RUSSIA = "testdata.region.Russia";
    private static final String TESTDATA_REGION_UKRANE = "testdata.region.Ukraine";

    public static String getUkraineRegion(){
        return TestDataReader.getTestData(TESTDATA_REGION_UKRANE);
    }

    public static String getRussiaRegion(){
        return TestDataReader.getTestData(TESTDATA_REGION_RUSSIA);
    }


}
