package com.databasevalidator.databasevalidator.filter.data_explore;

/**
 * Type of data exploring through models.
 * @author arek.biela@estimote.com (Arek Biela).
 */
public abstract class DataSelector {

    private int parameter;

    public DataSelector(int parameter) {
        this.parameter = parameter;
    }

    public int getParameter() {
        return parameter;
    }

    public static class AllData extends DataSelector {

        public AllData(int parameter) {
            super(parameter);
        }
    }

    /**
     * Data selector - min selector
     */

    public static class MinSelector extends DataSelector {

        private double minValue;

        public MinSelector(int parameter, double minValue) {
            super(parameter);
            this.minValue = minValue;
        }

        public double getMinValue() {
            return minValue;
        }
    }

    public static class MaxSelector {

    }
}
