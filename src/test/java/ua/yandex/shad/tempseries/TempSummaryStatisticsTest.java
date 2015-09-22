package ua.yandex.shad.tempseries;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TempSummaryStatisticsTest {
    @Test
    public void testConstructorAvgInit() {
        TempSummaryStatistics tempSummaryStatistics = new
                TempSummaryStatistics(1.1, 2.2, 3.3, 4.4);
        double expectedResult = 1.1;
        double actualResult = tempSummaryStatistics.getAvgTemp();
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testConstructorDevInit() {
        TempSummaryStatistics tempSummaryStatistics = new
                TempSummaryStatistics(1.1, 2.2, 3.3, 4.4);
        double expectedResult = 2.2;
        double actualResult = tempSummaryStatistics.getDevTemp();
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testConstructorMinInit() {
        TempSummaryStatistics tempSummaryStatistics = new
                TempSummaryStatistics(1.1, 2.2, 3.3, 4.4);
        double expectedResult = 3.3;
        double actualResult = tempSummaryStatistics.getMinTemp();
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testConstructorMaxInit() {
        TempSummaryStatistics tempSummaryStatistics = new
                TempSummaryStatistics(1.1, 2.2, 3.3, 4.4);
        double expectedResult = 4.4;
        double actualResult = tempSummaryStatistics.getMaxTemp();
        assertEquals(expectedResult, actualResult, 0.00001);
    }


}