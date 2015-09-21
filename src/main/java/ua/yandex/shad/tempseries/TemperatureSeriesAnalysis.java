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

    /**
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return minimum temperature
     */
    public double min(){
        if (temperatureSeries == null || temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }

        double minTemperature = Double.MAX_VALUE;
        for (double temperature:temperatureSeries){
            if (minTemperature > temperature){
                minTemperature = temperature;
            }
        }
        return minTemperature;
    }

    /**
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return maximum temperature
     */
    public double max(){
        if (temperatureSeries == null || temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }

        double maxTemperature = Double.MIN_VALUE;
        for (double temperature:temperatureSeries){
            if (maxTemperature < temperature){
                maxTemperature = temperature;
            }
        }
        return maxTemperature;
    }

    /**
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return value of temperature closest to zero, if there are 2 appropriate values, return biggest (positive)
     */
    public double findTempClosestToZero(){
        if (temperatureSeries == null || temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }

        double closestToZero = temperatureSeries[0];
        for (double temperature:temperatureSeries){
            if (Math.abs(closestToZero) > Math.abs(temperature)){
                closestToZero = temperature;
            }
            else{
                if (Math.abs(closestToZero) == Math.abs(temperature)) {
                    closestToZero = Math.max(closestToZero, temperature);
                }
            }
        }
        return closestToZero;
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
