package com.databasevalidator.databasevalidator.filter.model;

import java.util.List;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public interface IRepositoryInterface {

    void loadData();

    List<ResultItem> getMin();
}
