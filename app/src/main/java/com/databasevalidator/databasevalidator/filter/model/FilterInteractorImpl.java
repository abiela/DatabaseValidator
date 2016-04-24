package com.databasevalidator.databasevalidator.filter.model;

import android.content.Context;

import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;
import com.databasevalidator.databasevalidator.filter.model.realm.RealmRepositoryImpl;
import com.databasevalidator.databasevalidator.filter.model.realm.StudentRealm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class FilterInteractorImpl implements IFilterInteractor {

    private Map<DatabaseType, IRepositoryInterface> databaseMap;

    public FilterInteractorImpl(Context context) {
        setupDatabaseMap(context);
    }

    @Override
    public List<ResultItem> findSelectedItems(DatabaseType databaseType, DataSelector dataSelector) {
        return null;
    }

    private void setupDatabaseMap(Context context) {
        databaseMap = new HashMap<>();
        databaseMap.put(DatabaseType.REALM, new RealmRepositoryImpl(StudentRealm.class, context));
    }
}
