package ua.yandex.shad.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;

    /**
     * initialize temperatureSeries as empty array
     */
    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[0];
    }

    /**
     * @throws  InputMismatchException if array contain temperature less than absolute zero (-273)
     * @param temperatureSeries - contain temperatures not less than absolute zero (-273)
     *
     */
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double temperature:temperatureSeries){
            if (temperature < -273){
                throw new InputMismatchException();
            }
        }
        this.temperatureSeries = new double[temperatureSeries.length];
        System.arraycopy(temperatureSeries, 0, this.temperatureSeries, 0, temperatureSeries.length);
        
    }

    /**
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return average of temeratureSeries
     */
    public double average(){        
        if (temperatureSeries == null || temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }

        double sum = 0;
        for (double temperature:temperatureSeries){
            sum += temperature;
        }
        return sum/temperatureSeries.length;
    }

    /**
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return deviation of sample (divide on (n-1) not n)
     */
    public double deviation(){
        if (temperatureSeries == null || temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }

        double average = this.average();
        double sum = 0;
        for (double temperature:temperatureSeries){
            sum += (temperature - average)*(temperature - average);
        }

        return Math.sqrt(sum/(temperatureSeries.length - 1));
    }


    public double min(){
        return 0;
    }
     
    public double max(){
        return 0;
    }
    
    public double findTempClosestToZero(){
        return 0;
    }
    
    public double findTempClosestToValue(double tempValue){
        return 0;
}
    
    public double[] findTempsLessThen(double tempValue){
        return null;
    }
    
    public double[] findTempsGreaterThen(double tempValue){
        return null;
    }
    
    public TempSummaryStatistics summaryStatistics(){
        return null;
    }
    
    public int addTemps(double ... temps){
        return 0;
    }
}
