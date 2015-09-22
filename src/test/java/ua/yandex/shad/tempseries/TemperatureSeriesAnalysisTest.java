package ua.yandex.shad.tempseries;

import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class TemperatureSeriesAnalysisTest {


    @Test
    public void testConstructorReturnObjectOnAppropriateArray(){
        double[] arg = {1, 2, -273.0, 0, 300};
        assertNotNull(new TemperatureSeriesAnalysis(arg));

    }
    @Test
    public void testConstructorIfCopyInputArray(){
        double[] arg = {1, 2, -273.0, 0, 300};
        TemperatureSeriesAnalysis temperatureSeriesAnalysist = new TemperatureSeriesAnalysis(arg);
        arg[2] = 0;
        double expectedResult = -273.0;
        double actualResult = temperatureSeriesAnalysist.min();
        assertEquals(expectedResult, actualResult, 0.000001);



    }
    @Test
    public void testConstructorWithoutArgsReturnObject(){
        assertNotNull(new TemperatureSeriesAnalysis());
    }


    @Test(expected = InputMismatchException.class)
    public void testConstructorThrowExceptionWhenTemperatureLessThanAbsoluteZero(){
        double[] arg = {1, 2, 23, -273.1};
        new TemperatureSeriesAnalysis(arg);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageOfObjectConstructedWithoutArgsThrowsException(){
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis();
        temperatureSeriesAnalysis.average();

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAverageOfObjectConstructedOnEmptyArrayThrowsException(){
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(new double[0]);
        temperatureSeriesAnalysis.average();

    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {1.0, -5.0, 1.0, 6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.75;
        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationThrowsExceptionOnEmptyArray(){
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(new double[0]);
        temperatureSeriesAnalysis.deviation();
    }

    @Test
    public void testDeviation(){
        double[] arg = {1, 3, -5, 23, 444};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expextedResult = 196.385335;
        double actualResult = temperatureSeriesAnalysis.deviation();
        assertEquals(expextedResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinThrowsExceptionOnEmptyArray(){
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis();
        temperatureSeriesAnalysis.min();
    }

    @Test
    public void testMin(){
        double[] arg = {1, 3, -5, -234.3, 444};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expextedResult = -234.3;
        double actualResult = temperatureSeriesAnalysis.min();
        assertEquals(expextedResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWhenMinIsFirst(){
        double[] arg = {1, 3, 5, 234.3, 444};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expextedResult = 1;
        double actualResult = temperatureSeriesAnalysis.min();
        assertEquals(expextedResult, actualResult, 0.00001);
    }
    @Test
    public void testMinWhenMinIsLast(){
        double[] arg = {1, 3, 5, 234.3, 444, -4};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expextedResult = -4;
        double actualResult = temperatureSeriesAnalysis.min();
        assertEquals(expextedResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxThrowsExceptionOnEmptyArray(){
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis();
        temperatureSeriesAnalysis.max();
    }

    @Test
    public void testMax(){
        double[] arg = {1, 3, -5, -234.3, 444};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expextedResult = 444;
        double actualResult = temperatureSeriesAnalysis.max();
        assertEquals(expextedResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxOnNegativeValues(){
        double[] arg = {-4, -1, -3, -5, -234.3};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expextedResult = -1;
        double actualResult = temperatureSeriesAnalysis.max();
        assertEquals(expextedResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWhenMaxOnFirstPosition(){
        double[] arg = {-1, -3, -5, -234.3};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expextedResult = -1;
        double actualResult = temperatureSeriesAnalysis.max();
        assertEquals(expextedResult, actualResult, 0.00001);

    }
    @Test
    public void testMaxWhenMaxOnLastPosition(){
        double[] arg = {-1, -3, -5, -234.3, 2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expextedResult = 2;
        double actualResult = temperatureSeriesAnalysis.max();
        assertEquals(expextedResult, actualResult, 0.00001);

    }
    @Test
    public void testMaxWhenMaxOnOneElemantArray(){
        double[] arg = {-1};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expextedResult = -1;
        double actualResult = temperatureSeriesAnalysis.max();
        assertEquals(expextedResult, actualResult, 0.00001);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroThrowsExceptionOnEmptyArray(){
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis();
        temperatureSeriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZeroOnPositiveValues(){
        double[] arg = {6, 4, 3, 2, 9, 1.2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 1.2;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToZero();
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroOnNegativeValues(){
        double[] arg = {-6, -4, -3, -2, -9, -1.2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = -1.2;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToZero();
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroOnSignCollisionFirstPositive(){
        double[] arg = {-6, -4, -3, -2, -9, 1.2, 4, 10, -1.2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 1.2;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToZero();
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroOnSignCollisionFirstNegative(){
        double[] arg = {-6, -4, -3, -2, -9, -1.2, 4, 10, 1.2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 1.2;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToZero();
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueThrowsExceptionOnEmptyArray(){
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis();
        temperatureSeriesAnalysis.findTempClosestToValue(1);
    }

    @Test
    public void testFindTempClosestToZeroOnBiggestValues(){
        double[] arg = {6, 4, 3, 2, 9, 1.2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 1.2;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToValue(1);
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroOnSmallestValues(){
        double[] arg = {-6, -4, -3, -2, -9, -1.2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = -1.2;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToValue(10);
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueOnSignCollisionFirstPositive(){
        double[] arg = {-6, -4, -3, -2, -9, 2.2, 4, 10, -1.2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 2.2;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToValue(1.5);
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueOnSignCollisionFirstNegative(){
        double[] arg = {-6, -4, -3, -2, -9, -1.2, 4, 10, 2.2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 2.2;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToValue(1.5);
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenThrowsExceptionOnEmptyArray(){
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis();
        temperatureSeriesAnalysis.findTempsLessThen(1);
    }

    @Test
    public void testFindTempsLessThenBasic(){
        double[] arg = {5, 1, 2.4, 4, 5, 6};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double[] expectedResult = new double[]{1, 2.4};
        double[] actualResult = temperatureSeriesAnalysis.findTempsLessThen(3);
        assertArrayEquals(expectedResult, actualResult, 0.00000001);

    }
    @Test
    public void testFindTempsLessThenOnEdgeValues(){
        double[] arg = {5, 1, 2.4, 3, 4, 5, 6};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double[] expectedResult = new double[]{1, 2.4};
        double[] actualResult = temperatureSeriesAnalysis.findTempsLessThen(3);
        assertArrayEquals(expectedResult, actualResult, 0.00000001);

    }

    @Test
    public void testFindTempsLessThenOnEmptyOutput(){
        double[] arg = {5, 1, 2.4, 3, 4, 5, 6};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double[] expectedResult = new double[]{};
        double[] actualResult = temperatureSeriesAnalysis.findTempsLessThen(0);
        assertArrayEquals(expectedResult, actualResult, 0.00000001);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenThrowsExceptionOnEmptyArray(){
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis();
        temperatureSeriesAnalysis.findTempsGreaterThen(1);
    }

    @Test
    public void testFindTempsGreaterThenBasic(){
        double[] arg = {5, 1, 2.4, 4, 5, 6};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double[] expectedResult = new double[]{5, 2.4, 4, 5, 6};
        double[] actualResult = temperatureSeriesAnalysis.findTempsGreaterThen(2);
        assertArrayEquals(expectedResult, actualResult, 0.00000001);

    }
    @Test
    public void testFindTempsGreaterThenOnEdgeValues(){
        double[] arg = {5, 1, 2.4, 3, 4, 5, 6};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double[] expectedResult = new double[]{6};
        double[] actualResult = temperatureSeriesAnalysis.findTempsGreaterThen(5);
        assertArrayEquals(expectedResult, actualResult, 0.00000001);

    }

    @Test
    public void testFindTempsGreaterThenOnEmptyOutput(){
        double[] arg = {5, 1, 2.4, 3, 4, 5, 6};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double[] expectedResult = new double[]{};
        double[] actualResult = temperatureSeriesAnalysis.findTempsGreaterThen(10);
        assertArrayEquals(expectedResult, actualResult, 0.00000001);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsThrowsExceptionOnEmptyArray(){
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis();
        temperatureSeriesAnalysis.summaryStatistics();
    }
    @Test
    public void testSummaryStatisticsAvgerageValue(){
        double[] arg = {5, 1, 2.4, 3, 4, 5, 6};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 3.771428571;
        double actualResult = temperatureSeriesAnalysis.summaryStatistics().avgTemp;
        assertEquals(expectedResult, actualResult, 0.000001);
    }

    @Test
    public void testSummaryStatisticsDeviationValue(){
        double[] arg = {5, 1, 2.4, 3, 4, 5, 6};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 1.74137;
        double actualResult = temperatureSeriesAnalysis.summaryStatistics().devTemp;
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testSummaryStatisticsMinValue(){
        double[] arg = {5, 1, 2.4, 3, 4, 5, 6};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 1;
        double actualResult = temperatureSeriesAnalysis.summaryStatistics().minTemp;
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testSummaryStatisticsMaxValue(){
        double[] arg = {5, 1, 2.4, 3, 4, 5, 6};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 6;
        double actualResult = temperatureSeriesAnalysis.summaryStatistics().maxTemp;
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testAverageAfterAddingElements(){
        double[] arg = {1,1,1,1};
        double[] arg2 = {1,1};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        temperatureSeriesAnalysis.addTemps(arg2);
        double expectedResult = 1;
        double actualResult = temperatureSeriesAnalysis.average();
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationAfterAddingElements(){
        double[] arg = {1,1,1,1};
        double[] arg2 = {1,1};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        temperatureSeriesAnalysis.addTemps(arg2);
        double expectedResult = 0;
        double actualResult = temperatureSeriesAnalysis.deviation();
        assertEquals(expectedResult, actualResult, 0.00001);
    }
    @Test
    public void testMinAfterAddingElements(){
        double[] arg = {1,1,1,1};
        double[] arg2 = {1,1};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        temperatureSeriesAnalysis.addTemps(arg2);
        double expectedResult = 1;
        double actualResult = temperatureSeriesAnalysis.min();
        assertEquals(expectedResult, actualResult, 0.00001);
    }
    @Test
    public void testMaxAfterAddingElements(){
        double[] arg = {-1,-1,-1,-1};
        double[] arg2 = {-1,-1};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        temperatureSeriesAnalysis.addTemps(arg2);
        double expectedResult = -1;
        double actualResult = temperatureSeriesAnalysis.max();
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroAfterAddingElements(){
        double[] arg = {1,1,1,1};
        double[] arg2 = {1,1};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        temperatureSeriesAnalysis.addTemps(arg2);
        double expectedResult = 1;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToZero();
        assertEquals(expectedResult, actualResult, 0.00001);
    }
    @Test
    public void testFindTempClosestToValueWhenValuePresentedInArray(){
        double[] arg = {1,2,10,11};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 2;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToValue(2);
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueAfterAddingElements(){
        double[] arg = {1,1,1,1};
        double[] arg2 = {1,1};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        temperatureSeriesAnalysis.addTemps(arg2);
        double expectedResult = 1;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToValue(-1);
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThenAfterAddingElements(){
        double[] arg = {1,1,1,1};
        double[] arg2 = {1,1};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        temperatureSeriesAnalysis.addTemps(arg2);
        double[] expectedResult = new double[0];
        double[] actualResult = temperatureSeriesAnalysis.findTempsLessThen(1);
        assertArrayEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenAfterAddingElements(){
        double[] arg = {1,1,1,1};
        double[] arg2 = {1,1};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        temperatureSeriesAnalysis.addTemps(arg2);
        double[] expectedResult = new double[]{1,1,1,1,1,1};
        double[] actualResult = temperatureSeriesAnalysis.findTempsGreaterThen(-1);
        assertArrayEquals(expectedResult, actualResult, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsThrowsExceptionWhenTemperatureIsBelowAbsoluteZero(){
        double[] arg = {1,2,-274};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis();
        temperatureSeriesAnalysis.addTemps(arg);
    }

    @Test
    public void testAddTempsDoNotChangeNumberOfElementsWhenTryingToAddInappropriateTemps(){
        double[] arg1 = {1,2};
        double[] arg2 = {1,2,-274};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg1);
        try {
            temperatureSeriesAnalysis.addTemps(arg2);
        }catch (Exception ignored){}
        double[] expectedResults = new double[]{1,2};
        double[] actualResults = temperatureSeriesAnalysis.findTempsGreaterThen(-274);
        assertArrayEquals(expectedResults, actualResults, 0.0001);

    }

    @Test
    public void testAddTempsOnEmptyInputArray(){
        double[] arg1 = {1,2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg1);
        int expectedResult = 2;
        int actualResult = temperatureSeriesAnalysis.addTemps();
        assertEquals(expectedResult, actualResult);

    }
    @Test
    public void testAddTempsOnAppropriateInputData(){
        double[] arg1 = {1,2};
        double[] arg2 = {3,4,-273};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg1);
        temperatureSeriesAnalysis.addTemps(arg2);
        double[] expectedResult = {1,2,3,4};
        double[] actualResult = temperatureSeriesAnalysis.findTempsGreaterThen(0);
        assertArrayEquals(expectedResult, actualResult, 0.0001);

    }

    @Test
    public void testAddTempsReturnValue(){
        double[] arg1 = {1,2};
        double[] arg2 = {3,4,-273};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg1);
        double expectedResult = 5;
        double actualResult = temperatureSeriesAnalysis.addTemps(arg2);
        assertEquals(expectedResult, actualResult, 0.0001);

    }
    @Test
    public void testAddTempsAfterAddTempsIgnoreEmptyPartOfArray(){
        double[] arg1 = {1,2,3,4};
        double[] arg2 = {5,6};
        double[] arg3 = {7};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg1);  // array size = 4,
                                                                                                    // elements in array = 4
        temperatureSeriesAnalysis.addTemps(arg2);   // array size = 8, elements in array = 6, others - zero
        temperatureSeriesAnalysis.addTemps(arg3);   // array size = 8, elements in array = 7, others - zero
        double[] expectedResult = {1,2,3,4,5,6,7};
        double[] actualResult = temperatureSeriesAnalysis.findTempsGreaterThen(-1);
        assertArrayEquals(expectedResult, actualResult, 0.0001);

    }

    @Test
    public void testAddTempsCopyInputArray(){
        double[] arg1 = {1,2};
        double[] arg2 = {3,4};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg1);
        temperatureSeriesAnalysis.addTemps(arg2);
        arg2[0]= 10;
        double[] expectedResult = {1,2,3,4};
        double[] actualResult = temperatureSeriesAnalysis.findTempsGreaterThen(0);
        assertArrayEquals(expectedResult, actualResult, 0.0001);

    }


}
