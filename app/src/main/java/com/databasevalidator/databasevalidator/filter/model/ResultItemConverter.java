package com.databasevalidator.databasevalidator.filter.model;

import java.util.List;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public interface ResultItemConverter<T> {

    List<ResultItem> toResultItem(T rawResult);
}
