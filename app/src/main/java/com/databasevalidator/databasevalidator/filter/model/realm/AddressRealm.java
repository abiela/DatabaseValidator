package com.databasevalidator.databasevalidator.filter.model.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class AddressRealm extends RealmObject {

    @PrimaryKey
    private long addressId;

    private String city;
    private String streetName;

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
