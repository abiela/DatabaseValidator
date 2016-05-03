package com.databasevalidator.databasevalidator.filter.presenter;

import android.content.Context;
import android.util.Log;

import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;
import com.databasevalidator.databasevalidator.filter.model.DatabaseCallback;
import com.databasevalidator.databasevalidator.filter.model.DatabaseType;
import com.databasevalidator.databasevalidator.filter.model.FilterInteractorImpl;
import com.databasevalidator.databasevalidator.filter.model.IFilterInteractor;
import com.databasevalidator.databasevalidator.filter.model.ResultItem;
import com.databasevalidator.databasevalidator.filter.model.StudentResultItem;
import com.databasevalidator.databasevalidator.filter.utils.C;
import com.databasevalidator.databasevalidator.filter.view.IFilterViewInterface;

import java.util.List;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class FilterPresenterImpl implements IFilterPresenter {

    private IFilterViewInterface filterViewInterface;
    private IFilterInteractor filterInteractor;
    private DatabaseType databaseType;
    private DatabaseCallback databaseCallback;

    public FilterPresenterImpl(IFilterViewInterface filterViewInterface) {
        this.filterViewInterface = filterViewInterface;
        databaseType = DatabaseType.AGDS;
        setupOnDatabaseReadyCallback();
        Log.d(C.LOG_TAG, "FilterPresenterImpl: constructing...");
        filterInteractor = new FilterInteractorImpl((Context) filterViewInterface, databaseCallback);
        List<ResultItem> resultItems = filterInteractor.findSelectedItems(databaseType, new DataSelector.AllData(""));
        filterViewInterface.showSelectedResults(resultItems);
    }


    @Override
    public void onDataExploringTypeSelected(DataSelector dataSelector) {
        List<ResultItem> resultItems = filterInteractor.findSelectedItems(databaseType, dataSelector);
        filterViewInterface.showSelectedResults(resultItems);
    }

    @Override
    public void onDatabaseTypeSelected(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }

    private void setupOnDatabaseReadyCallback() {
        databaseCallback = new DatabaseCallback() {
            @Override
            public void onDatabaseReady(DatabaseType databaseType) {
                Log.d(C.LOG_TAG, "onDatabaseReady()");
            }
        };
    }
}
