package com.databasevalidator.databasevalidator.filter.model;

import android.content.Context;

import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;
import com.databasevalidator.databasevalidator.filter.model.agds.AgdsRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class FilterInteractorImpl implements IFilterInteractor {

    private Map<DatabaseType, IRepositoryInterface> databaseMap;
    private boolean readyToUse;
    private DatabaseCallback databaseCallback;

    public FilterInteractorImpl(Context context, DatabaseCallback databaseCallback) {
        this.databaseCallback = databaseCallback;
        setupDatabaseMap(context);
    }

    @Override
    public List<ResultItem> findSelectedItems(DatabaseType databaseType, DataSelector dataSelector) {
        IRepositoryInterface selectedDatabase = databaseMap.get(databaseType);
        return selectedDatabase.onDataSelectorTriggered(dataSelector);
    }

    private void setupDatabaseMap(Context context) {
        databaseMap = new HashMap<>();
//        databaseMap.put(DatabaseType.REALM, new RealmRepositoryImpl(StudentRealm.class, context));
        databaseMap.put(DatabaseType.AGDS, new AgdsRepositoryImpl(context, databaseCallback));
    }
}
