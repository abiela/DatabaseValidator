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
    private String streetname;

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

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }
}
