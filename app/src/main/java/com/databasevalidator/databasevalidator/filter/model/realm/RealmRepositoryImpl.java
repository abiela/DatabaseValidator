package com.databasevalidator.databasevalidator.filter.model.realm;

import android.content.Context;
import android.util.Log;

import com.databasevalidator.databasevalidator.filter.model.IRepositoryInterface;
import com.databasevalidator.databasevalidator.filter.model.ResultItem;
import com.databasevalidator.databasevalidator.filter.presenter.IFilterPresenter;
import com.databasevalidator.databasevalidator.filter.utils.C;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class RealmRepositoryImpl implements IRepositoryInterface {

    private Class realmTableClass;
    private Realm realmInstance;

    public RealmRepositoryImpl (Class realmTableClass, Context context) {
        this.realmTableClass = realmTableClass;
        checkRealmInstance(context);
        loadData();
    }

    @Override
    public void loadData() {
        if (realmInstance.where(realmTableClass).findAll().size() != 0) {
            Log.d(C.LOG_TAG, "Realm table is not null");
        }

        else {
            Log.d(C.LOG_TAG, "Realm table is null");
            StudentRealmWizard.instantiateFieldOfStudy(realmInstance);
            StudentRealmWizard.instantiateAddress(realmInstance);
            StudentRealmWizard.instantiateStudent(realmInstance);
        }
    }

    @Override
    public List<ResultItem> getMin() {
        return null;
    }

    private void checkRealmInstance(Context context) {

        if (realmInstance == null) {
            RealmConfiguration config = new RealmConfiguration.Builder(context).build();
            Realm.setDefaultConfiguration(config);
            realmInstance = Realm.getDefaultInstance();
        }
    }
}
