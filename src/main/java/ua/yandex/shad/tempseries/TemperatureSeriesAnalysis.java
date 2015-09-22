package ua.yandex.shad.tempseries;

import java.io.Serializable;
import java.util.Comparator;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    private int curNumberOfElements = 0;

    private static class DoubleComparator implements Comparator<Double>, Serializable  {
        @Override
        public int compare(Double o1, Double o2) {
            return o1.compareTo(o2);
        }
    }
    private static class ReversedDoubleComparator implements Comparator<Double>, Serializable {
        @Override
        public int compare(Double o1, Double o2) {
            return o2.compareTo(o1);
        }
    }

    /**
     * initialize temperatureSeries as empty array
     */
    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[0];
        curNumberOfElements = 0;
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
        curNumberOfElements = temperatureSeries.length;

    }

    /**
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return average of temeratureSeries
     */
    public double average(){        
        if (temperatureSeries == null || curNumberOfElements == 0){
            throw new IllegalArgumentException();
        }

        double sum = 0;
        for (int i = 0; i < curNumberOfElements; i++){
            sum += temperatureSeries[i];
        }
        return sum/curNumberOfElements;
    }

    /**
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return deviation of sample (divide on (n-1) not n)
     */
    public double deviation(){
        if (temperatureSeries == null || curNumberOfElements == 0){
            throw new IllegalArgumentException();
        }

        double average = this.average();
        double sum = 0;
        for (int i = 0; i < curNumberOfElements; i++){
            sum += (temperatureSeries[i] - average)*(temperatureSeries[i] - average);
        }

        return Math.sqrt(sum/(curNumberOfElements - 1));
    }

    /**
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return minimum temperature
     */
    public double min(){
        if (temperatureSeries == null || curNumberOfElements == 0){
            throw new IllegalArgumentException();
        }

        double minTemperature = temperatureSeries[0];
        for (int i = 1; i < curNumberOfElements; i++){
            if (minTemperature > temperatureSeries[i]){
                minTemperature = temperatureSeries[i];
            }
        }
        return minTemperature;
    }

    /**
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return maximum temperature
     */
    public double max(){
        if (temperatureSeries == null || curNumberOfElements == 0){
            throw new IllegalArgumentException();
        }

        double maxTemperature = temperatureSeries[0];
        for (int i = 1; i < curNumberOfElements; i++){
            if (maxTemperature < temperatureSeries[i]){
                maxTemperature = temperatureSeries[i];
            }
        }
        return maxTemperature;
    }

    /**
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return value of temperature closest to zero, if there are 2 appropriate values, return biggest (positive)
     */
    public double findTempClosestToZero(){
        return findTempClosestToValue(0);
    }


    /**
     * @param tempValue - value of temperature to which find closest
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return value of temperature closest to tempValue, if there are 2 appropriate values, return biggest (positive)
     */
    public double findTempClosestToValue(double tempValue){
        if (temperatureSeries == null || curNumberOfElements == 0){
            throw new IllegalArgumentException();
        }

        double closestToValue = temperatureSeries[0];
        for (int i = 0; i<curNumberOfElements; i++){
            if (Math.abs(temperatureSeries[i] - tempValue) < 0.000001) {
                closestToValue = tempValue;
                break;
            }
            if (Math.abs(closestToValue-tempValue) > Math.abs(temperatureSeries[i]-tempValue)) {
                closestToValue = temperatureSeries[i];
            }
            else{
                if (Math.abs(Math.abs(closestToValue - tempValue) - Math.abs(temperatureSeries[i] - tempValue)) < 0.000001) {
                    closestToValue = Math.max(closestToValue, temperatureSeries[i]);
                }
            }
        }
        return closestToValue;
    }

    private double[] findTempsXThan(double tempValue, Comparator<Double> comparator){
        if (temperatureSeries == null || curNumberOfElements == 0){
            throw new IllegalArgumentException();
        }

        int numberOfAppropriateTemperatures = 0;
        for (int i = 0; i < curNumberOfElements; i++){
            if (comparator.compare(temperatureSeries[i], tempValue) > 0){
                numberOfAppropriateTemperatures++;
            }
        }
        double[] resArray = new double[numberOfAppropriateTemperatures];
        int i = 0;
        for (int j = 0; j < curNumberOfElements; j++){
            if (comparator.compare(temperatureSeries[j], tempValue) > 0){
                resArray[i] = temperatureSeries[j];
                i++;
            }
        }
        return resArray;

    }
    /**
     *
     * @throws IllegalArgumentException if array is empty or non initialised
     * @param tempValue - value of temperature
     * @return array of values, that less than tempValue, in the same order, like in source array (temperatureSeries)
     */
    public double[] findTempsLessThen(double tempValue) {
        return findTempsXThan(tempValue, new ReversedDoubleComparator());
    }

    /**
     *
     * @throws IllegalArgumentException if array is empty or non initialised
     * @param tempValue value of temperature
     * @return array of values, that greater than tempValue, in the same order, like in source array (temperatureSeries)
     */
    public double[] findTempsGreaterThen(double tempValue){
        return findTempsXThan(tempValue, new DoubleComparator());
    }

    /**
     *
     * @throws IllegalArgumentException if array is empty or non initialised
     * @return immutable object, that contain avgTemp, devTemp, minTemp, maxTemp
     */
    public TempSummaryStatistics summaryStatistics(){
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    /**
     * add to the end of temperatureSeries new values. If one of new values is less than absolute Zero(-273) do not
     * modify temperatureSeries
     * @throws InputMismatchException, if one of new values is less than absolute Zero(-273)
     * @param temps array of temperatures
     * @return number of elements in updated array
     */
    public int addTemps(double ... temps){
        for (double temperature:temps){
            if (temperature < -273){
                throw new InputMismatchException();
            }
        }
        if (temperatureSeries.length - curNumberOfElements < temps.length){
            increaseArraySize(curNumberOfElements + temps.length);
        }
        System.arraycopy(temps, 0, temperatureSeries, curNumberOfElements, temps.length);
        curNumberOfElements += temps.length;

        return curNumberOfElements;
    }

    private void increaseArraySize(int newNumberOfElements) {
        int newSize = calculateNewSize(newNumberOfElements);
        double[] newArray = new double[newSize];
        System.arraycopy(temperatureSeries, 0, newArray, 0, curNumberOfElements);
        temperatureSeries = newArray;
    }

    private int calculateNewSize(int newNumberOfElements) {
        return temperatureSeries.length *
                (int) Math.pow(2,
                        (int) Math.ceil(Math.log(
                                ((double)newNumberOfElements)/temperatureSeries.length)/Math.log(2)));
    }
}
