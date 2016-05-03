package com.databasevalidator.databasevalidator.filter.model.realm;

import android.content.Context;
import android.util.Log;

import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;
import com.databasevalidator.databasevalidator.filter.model.IRepositoryInterface;
import com.databasevalidator.databasevalidator.filter.model.ResultItem;
import com.databasevalidator.databasevalidator.filter.model.StudentResultItem;
import com.databasevalidator.databasevalidator.filter.utils.C;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

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
            Log.d(C.LOG_TAG, "Loading Realm Repository - Realm database is not null.");
        }

        else {
            Log.d(C.LOG_TAG, "Loading Realm Repository - Realm table is null.");
            StudentRealmWizard.instantiateFieldOfStudy(realmInstance);
            StudentRealmWizard.instantiateAddress(realmInstance);
            StudentRealmWizard.instantiateStudent(realmInstance);
        }
    }

    @Override
    public List<ResultItem> getAllRecords() {
        return null;
    }

    @Override
    public List<ResultItem> onDataSelectorTriggered(DataSelector dataSelector) {
        //TODO: Check by reflection if field name works
        Log.d(C.LOG_TAG, StudentResultItem.class.getFields()[dataSelector.getParameter()].toString());
        return null;
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

    private List<StudentResultItem> convertToResultItemList(RealmResults<StudentRealm> queryResultItems) {
        List<StudentResultItem> convertedResultItems = new ArrayList<>();
        for (StudentRealm studentRealmObject : queryResultItems) {

            StudentResultItem studentResultItem = new StudentResultItem.Builder()
                    .setFirstName(studentRealmObject.getFirstName())
                    .setSurname(studentRealmObject.getSurname())
                    .setScholarshipAmount(studentRealmObject.getScholarshipAmount())
                    .setYearOfStudy(studentRealmObject.getYearOfStudy())
                    .setCity(studentRealmObject.getAddress().getCity())
                    .setStreetName(studentRealmObject.getAddress().getStreetname())
                    .setFieldOfStudy(studentRealmObject.getFieldOfStudy().getName())
                    .build();
            convertedResultItems.add(studentResultItem);
        }
        return convertedResultItems;
    }
}
