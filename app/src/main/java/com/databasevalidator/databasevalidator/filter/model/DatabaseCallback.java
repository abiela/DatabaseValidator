package com.databasevalidator.databasevalidator.filter.model;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public interface DatabaseCallback {

    void onDatabaseReady(DatabaseType databaseType);
}
