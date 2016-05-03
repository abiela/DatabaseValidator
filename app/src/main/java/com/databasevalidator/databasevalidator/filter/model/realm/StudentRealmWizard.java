package com.databasevalidator.databasevalidator.filter.model.realm;

import android.util.Log;

import com.databasevalidator.databasevalidator.filter.utils.C;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class StudentRealmWizard {

    private static final String[] FIELDS_OF_STUDY = {"Computer Science", "Geology"};

    private static final String[] CITIES = {"Cracow", "Warsaw"};
    private static final String[] STREETNAMES = {"Lipowa", "Akacjowa", "Topolowa"};
    private static final int ADDRESS_AMOUNT = 3;

    private static final String[] FIRST_NAMES = {"Tomasz", "Andrzej", "Marcin"};
    private static final String[] SURNAMES = {"Nowak", "Kowalski", "Debowski", "Wojcik", "Olech"};
    private static final int STUDENTS_AMOUNT = 5;

    public static void instantiateFieldOfStudy(Realm realm) {
        realm.beginTransaction();
        for (int i = 0; i < FIELDS_OF_STUDY.length; i++) {
            FieldOfStudyRealm fieldOfStudyRealm = realm.createObject(FieldOfStudyRealm.class);
            fieldOfStudyRealm.setFieldOfStudyId(i + 1);
            fieldOfStudyRealm.setName(FIELDS_OF_STUDY[i]);
        }
        realm.commitTransaction();
        Log.d(C.LOG_TAG, "Fields of study items in database: " + realm.where(FieldOfStudyRealm.class).findAll().size());
    }

    public static void instantiateAddress(Realm realm) {
        realm.beginTransaction();
        for (int i = 0; i < ADDRESS_AMOUNT; i++) {
            AddressRealm addressRealm = realm.createObject(AddressRealm.class);
            addressRealm.setAddressId(i + 1);
            addressRealm.setCity(CITIES[i / 2]);
            addressRealm.setStreetname(STREETNAMES[i]);
        }
        realm.commitTransaction();
        Log.d(C.LOG_TAG, "Address items in database: " + realm.where(AddressRealm.class).findAll().size());
    }

    public static void instantiateStudent(Realm realm) {
        realm.beginTransaction();
        for (int i = 0; i < STUDENTS_AMOUNT; i++) {
            StudentRealm studentRealm = realm.createObject(StudentRealm.class);
            studentRealm.setStudentId(i + 1);
            studentRealm.setFirstName(FIRST_NAMES[i % 3]);
            studentRealm.setSurname(SURNAMES[i]);
            studentRealm.setScholarshipAmount(100 + i * 100);
            studentRealm.setYearOfStudy(i + 1);
            studentRealm.setAddress(realm.where(AddressRealm.class).equalTo("addressId", (i % 3) + 1).findAll().first());
            studentRealm.setFieldOfStudy(realm.where(FieldOfStudyRealm.class).equalTo("fieldOfStudyId", (i % 2) + 1).findFirst());
        }
        realm.commitTransaction();
        Log.d(C.LOG_TAG, "Student items in database: " + realm.where(StudentRealm.class).findAll().size());
    }
}
