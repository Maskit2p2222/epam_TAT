package test;

import page.MainPage;
import service.RegionDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegionChangingTests extends CommonConditions{

    @Test
    public void testChangRegionOnRussia(){
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
    public void testChangRegionOnUkraine(){
        String testRegion = RegionDataReader.getUkraineRegion();
        String expectedRegion = new MainPage(driver)
                .openPage()
                .clickOnRegionChangSpan()
                .changRegion()
                .getChangingRegion();
        Assert.assertEquals(testRegion,expectedRegion.toLowerCase());
    }

}
