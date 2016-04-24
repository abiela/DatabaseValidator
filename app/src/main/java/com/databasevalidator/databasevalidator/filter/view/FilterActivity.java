package com.databasevalidator.databasevalidator.filter.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.databasevalidator.databasevalidator.R;
import com.databasevalidator.databasevalidator.filter.model.ResultItem;
import com.databasevalidator.databasevalidator.filter.presenter.FilterPresenterImpl;
import com.databasevalidator.databasevalidator.filter.presenter.IFilterPresenter;

import java.util.List;

public class FilterActivity extends AppCompatActivity implements IFilterViewInterface {

    private IFilterPresenter filterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        setupPresenter();
    }

    @Override
    public void showSelectedResults(List<ResultItem> resultItems) {

    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    private void setupPresenter() {
        filterPresenter = new FilterPresenterImpl(this);
    }
}
