package ua.yandex.shad.tempseries;

import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TemperatureSeriesAnalysisTest {


    @Test
    public void testConstructorReturnObjectOnAppropriateArray(){
        double[] arg = {1, 2, -273.0, 0, 300};
        assertNotNull(new TemperatureSeriesAnalysis(arg));

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
    public void testFindTempClosestOnSignCollisionFirstPositive(){
        double[] arg = {-6, -4, -3, -2, -9, 1.2, 4, 10, -1.2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 1.2;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToZero();
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestOnSignCollisionFirstNegative(){
        double[] arg = {-6, -4, -3, -2, -9, -1.2, 4, 10, 1.2};
        TemperatureSeriesAnalysis temperatureSeriesAnalysis = new TemperatureSeriesAnalysis(arg);
        double expectedResult = 1.2;
        double actualResult = temperatureSeriesAnalysis.findTempClosestToZero();
        assertEquals(expectedResult, actualResult, 0.00001);
    }


}
