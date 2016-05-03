package com.databasevalidator.databasevalidator.filter.model;

/**
 * Search result entity that is ready to be displayed.
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class StudentResultItem {

    /**
     * Student data fields
     */
    private String firstName;
    private String surname;
    private int scholarshipAmount;
    private int yearOfStudy;

    /**
     * Student's address data fields
     */
    private String city;
    private String streetname;

    /**
     * Student's field of study data fields
     */
    private String fieldOfStudyName;

    public StudentResultItem() {

    }

    public StudentResultItem(String firstName, String surname, int scholarshipAmount, int yearOfStudy, String city, String streetname, String fieldOfStudyName) {
        this.firstName = firstName;
        this.surname = surname;
        this.scholarshipAmount = scholarshipAmount;
        this.yearOfStudy = yearOfStudy;
        this.city = city;
        this.streetname = streetname;
        this.fieldOfStudyName = fieldOfStudyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public int getScholarshipAmount() {
        return scholarshipAmount;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getCity() {
        return city;
    }

    public String getStreetname() {
        return streetname;
    }

    public String getFieldOfStudyName() {
        return fieldOfStudyName;
    }

    /**
     * Result Item - Builder Pattern
     */

    public static class Builder {

        private String nestedFirstName;
        private String nestedSurname;
        private int nestedScholarshipAmount;
        private int nestedYearOfStudy;
        private String nestedCity;
        private String nestedStreetname;
        private String nestedFieldOfStudyName;

        public Builder() {
        }

        public Builder setFirstName(String firstName) {
            this.nestedFirstName = firstName;
            return this;
        }

        public Builder setSurname(String surname) {
            this.nestedSurname = surname;
            return this;
        }

        public Builder setScholarshipAmount(int scholarshipAmount) {
            this.nestedScholarshipAmount = scholarshipAmount;
            return this;
        }

        public Builder setYearOfStudy(int yearOfStudy) {
            this.nestedYearOfStudy = yearOfStudy;
            return this;
        }

        public Builder setCity(String city) {
            this.nestedCity = city;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.nestedStreetname = streetName;
            return this;
        }

        public Builder setFieldOfStudy(String fieldOfStudy) {
            this.nestedFieldOfStudyName = fieldOfStudy;
            return this;
        }

        public StudentResultItem build() {
            return new StudentResultItem(nestedFirstName, nestedSurname, nestedScholarshipAmount, nestedYearOfStudy, nestedCity, nestedStreetname, nestedFieldOfStudyName);
        }

    }
}
