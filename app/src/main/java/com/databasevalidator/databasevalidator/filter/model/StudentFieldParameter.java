package com.databasevalidator.databasevalidator.filter.model;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public enum StudentFieldParameter {

    FIRST_NAME(1, "firstName"),
    SURNAME(2, "surname"),
    SCHOLARSHIP_AMOUNT(3, "scholarshipAmount"),
    YEAR_OF_STUDY(4, "yearOfStudy"),
    CITY(5, "address.city"),
    STREETNAME(6, "address.streetname"),
    FIELD_OF_STUDY(7, "fieldOfStudy.name");


    private int parameterValue;
    private String name;

    StudentFieldParameter (int parameterValue, String name) {
        this.parameterValue = parameterValue;
        this.name = name;
    }

    StudentFieldParameter getByValue(int parameterValue) {
        return FIELD_OF_STUDY;
    }
}
