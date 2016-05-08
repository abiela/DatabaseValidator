package com.databasevalidator.databasevalidator.filter.model;

import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;

import java.util.List;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public interface IRepositoryInterface {

    void loadData();

    List<ResultItem> getAllRecords();

    List<ResultItem> onDataSelectorTriggered(DataSelector dataSelector);

    List<ResultItem> getMin(String attributeName);

    List<ResultItem> getMax(String attributeName);

    List<ResultItem> getSorted(String attributeName);

    List<ResultItem> getMostSimilarElements(String attributeName, double[] values, int amount);

    List<ResultItem> getLeastSimilarElements(String attributeName, double[] values, int amount);

    List<ResultItem> getAboveSimiliratyRateElements(String attributeName, double[] values, float percentageRate);

    List<ResultItem> getBelowSimilarityRateElements(String attributeName, double[] values, float percentageRate);

    List<ResultItem> getElementsInRange(String atrributeName, double minValue, double maxValue);
}
