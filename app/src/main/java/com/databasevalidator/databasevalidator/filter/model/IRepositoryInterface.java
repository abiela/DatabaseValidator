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

    List<ResultItem> getMin();
}
