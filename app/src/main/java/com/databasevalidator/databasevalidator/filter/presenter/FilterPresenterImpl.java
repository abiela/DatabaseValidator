package com.databasevalidator.databasevalidator.filter.presenter;

import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;
import com.databasevalidator.databasevalidator.filter.model.DatabaseType;
import com.databasevalidator.databasevalidator.filter.model.FilterInteractorImpl;
import com.databasevalidator.databasevalidator.filter.model.IFilterInteractor;
import com.databasevalidator.databasevalidator.filter.view.IFilterViewInterface;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class FilterPresenterImpl implements IFilterPresenter {

    private IFilterViewInterface filterViewInterface;
    private IFilterInteractor filterInteractor;

    public FilterPresenterImpl(IFilterViewInterface filterViewInterface) {
        this.filterViewInterface = filterViewInterface;
        filterInteractor = new FilterInteractorImpl(filterViewInterface.getContext());
    }


    @Override
    public void onDataExploringTypeSelected(DataSelector dataSelector) {

    }

    @Override
    public void onDatabaseTypeSelected(DatabaseType databaseType) {

    }
}
