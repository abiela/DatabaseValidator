package com.databasevalidator.databasevalidator.filter.presenter;

import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;
import com.databasevalidator.databasevalidator.filter.model.DatabaseType;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public interface IFilterPresenter {

    void onDataExploringTypeSelected(DataSelector dataSelector);

    void onDatabaseTypeSelected(DatabaseType databaseType);
}
