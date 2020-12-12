package com.epam.ta.test;

import com.epam.ta.page.MainPage;
import com.epam.ta.service.RegionDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class RegionChangingTests extends CommonConditions{

    @Test
    public void changRegionOnRussia(){
        String testRegion = RegionDataReader.getRussiaRegion();
        String expectedRegion = new MainPage(driver)
                .openPage()
                .clickOnRegionChangSpan()
                .changRegion()
                .clickOnRegionChangSpan()
                .changRegion()
                .getChangingRegion();
        Assert.assertEquals(testRegion,expectedRegion.toLowerCase());
    }

    @Test
    public void changRegionOnUkraine(){
        String testRegion = RegionDataReader.getUkraineRegion();
        String expectedRegion = new MainPage(driver)
                .openPage()
                .clickOnRegionChangSpan()
                .changRegion()
                .getChangingRegion();
        Assert.assertEquals(testRegion,expectedRegion.toLowerCase());
    }

}
