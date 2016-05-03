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

    public static class MaxSelector extends DataSelector{
        public MaxSelector(String attribute) {
            super(attribute);
        }
    }

    public static class SortSelector extends DataSelector{
        public SortSelector(String attribute) {
            super(attribute);
        }
    }
}
