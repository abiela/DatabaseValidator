package com.databasevalidator.databasevalidator.filter.view;

import android.content.Context;

import com.databasevalidator.databasevalidator.filter.model.ResultItem;

import java.util.List;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public interface IFilterViewInterface {

    void showSelectedResults(List<ResultItem> resultItems);
    Context getContext();
}
