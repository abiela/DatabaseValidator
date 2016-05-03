package com.databasevalidator.databasevalidator.filter.model.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class StudentRealm extends RealmObject {

    @PrimaryKey
    private long studentId;

    private String firstName;
    private String surname;
    private int scholarshipAmount;
    private int yearOfStudy;
    private AddressRealm address;
    private FieldOfStudyRealm fieldOfStudy;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(int scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public AddressRealm getAddress() {
        return address;
    }

    public void setAddress(AddressRealm address) {
        this.address = address;
    }

    public FieldOfStudyRealm getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudyRealm fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }
}
