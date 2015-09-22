package ua.yandex.shad.tempseries;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TempSummaryStatisticsTest {
    @Test
    public void testConstructorAvgInit(){
        TempSummaryStatistics tempSummaryStatistics = new TempSummaryStatistics(1.1,2.2,3.3,4.4);
        double expectedResult = 1.1;
        double actualResult = tempSummaryStatistics.avgTemp;
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testConstructorDevInit(){
        TempSummaryStatistics tempSummaryStatistics = new TempSummaryStatistics(1.1,2.2,3.3,4.4);
        double expectedResult = 2.2;
        double actualResult = tempSummaryStatistics.devTemp;
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testConstructorMinInit(){
        TempSummaryStatistics tempSummaryStatistics = new TempSummaryStatistics(1.1,2.2,3.3,4.4);
        double expectedResult = 3.3;
        double actualResult = tempSummaryStatistics.minTemp;
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testConstructorMaxInit(){
        TempSummaryStatistics tempSummaryStatistics = new TempSummaryStatistics(1.1,2.2,3.3,4.4);
        double expectedResult = 4.4;
        double actualResult = tempSummaryStatistics.maxTemp;
        assertEquals(expectedResult, actualResult, 0.00001);
    }



}