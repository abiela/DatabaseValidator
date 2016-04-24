package com.databasevalidator.databasevalidator.filter.model;

import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;

import java.util.List;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public interface IFilterInteractor {

    List<ResultItem> findSelectedItems(DatabaseType databaseType, DataSelector dataSelector);
}
