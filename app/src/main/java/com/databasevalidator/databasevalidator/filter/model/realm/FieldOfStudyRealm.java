package com.databasevalidator.databasevalidator.filter.model.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class FieldOfStudyRealm extends RealmObject {

    @PrimaryKey
    private long fieldOfStudyId;

    private String name;

    public long getFieldOfStudyId() {
        return fieldOfStudyId;
    }

    public void setFieldOfStudyId(long fieldOfStudyId) {
        this.fieldOfStudyId = fieldOfStudyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
