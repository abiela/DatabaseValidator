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

    public static class MinSelector {

        public MinSelector(int parameter, int maxValue) {
            super();
        }
    }

    public static class MaxSelector {

    }
}
