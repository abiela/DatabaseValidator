package com.databasevalidator.databasevalidator.filter.data_explore;

/**
 * Type of data exploring through models.
 * @author arek.biela@estimote.com (Arek Biela).
 */
public abstract class DataSelector {

    private String attribute;

    public DataSelector(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

    /**
     * Data selector - all data selector
     */

    public static class AllData extends DataSelector {
        public AllData(String attribute) {
            super(attribute);
        }
    }

    /**
     * Data selector - min selector
     */

    public static class MinSelector extends DataSelector {
        public MinSelector(String attribute) {
            super(attribute);
        }
    }

    /**
     * Data selector - max selector
     */
    public static class MaxSelector extends DataSelector{
        public MaxSelector(String attribute) {
            super(attribute);
        }
    }

    /**
     * Data selector - sort selector
     */
    public static class SortSelector extends DataSelector{
        public SortSelector(String attribute) {
            super(attribute);
        }
    }

    /**
     * Data selector - find most similar selector
     */
    public static class FindMostSimilarSelector extends DataSelector{

        private double[] loadedElementValues;
        private int amount;

        public FindMostSimilarSelector(String attribute, double[] loadedElementValues, int amount) {
            super(attribute);
            this.loadedElementValues = loadedElementValues;
            this.amount = amount;
        }

        public double[] getLoadedElementValues() {
            return loadedElementValues;
        }

        public int getAmount() {
            return amount;
        }
    }

    /**
     * Data selector - find least similar selector
     */
    public static class FindLeastSimilarSelector extends DataSelector{

        private double[] loadedElementValues;
        private int amount;

        public FindLeastSimilarSelector(String attribute, double[] loadedElementValues, int amount) {
            super(attribute);
            this.loadedElementValues = loadedElementValues;
            this.amount = amount;
        }

        public double[] getLoadedElementValues() {
            return loadedElementValues;
        }

        public int getAmount() {
            return amount;
        }
    }

    /**
     * Data selector - find above percentage rate selector
     */
    public static class FindAbovePercentageRateSelector extends DataSelector{

        private double[] loadedElementValues;
        private float percentageRate;

        public FindAbovePercentageRateSelector(String attribute, double[] loadedElementValues, float percentageRate) {
            super(attribute);
            this.loadedElementValues = loadedElementValues;
            this.percentageRate = percentageRate;
        }

        public double[] getLoadedElementValues() {
            return loadedElementValues;
        }

        public float getPercentageRate() {
            return percentageRate;
        }
    }

    /**
     * Data selector - find below percentage rate selector
     */
    public static class FindBelowPercentageRateSelector extends DataSelector{

        private double[] loadedElementValues;
        private float percentageRate;

        public FindBelowPercentageRateSelector(String attribute, double[] loadedElementValues, float percentageRate) {
            super(attribute);
            this.loadedElementValues = loadedElementValues;
            this.percentageRate = percentageRate;
        }

        public double[] getLoadedElementValues() {
            return loadedElementValues;
        }

        public float getPercentageRate() {
            return percentageRate;
        }
    }

    /**
     * Data selector - in range selector
     */
    public static class InRangeSelector extends DataSelector{

        private double minValue;
        private double maxValue;

        public InRangeSelector(String attribute, double minValue, double maxValue) {
            super(attribute);
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        public double getMinValue() {
            return minValue;
        }

        public double getMaxValue() {
            return maxValue;
        }
    }
}
