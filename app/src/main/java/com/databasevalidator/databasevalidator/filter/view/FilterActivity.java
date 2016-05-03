package com.databasevalidator.databasevalidator.filter.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.databasevalidator.databasevalidator.R;
import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;
import com.databasevalidator.databasevalidator.filter.model.ResultItem;
import com.databasevalidator.databasevalidator.filter.presenter.FilterPresenterImpl;
import com.databasevalidator.databasevalidator.filter.presenter.IFilterPresenter;
import com.databasevalidator.databasevalidator.filter.utils.C;

import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends AppCompatActivity implements IFilterViewInterface {

    private IFilterPresenter filterPresenter;
    private RecyclerView resultItemList;
    private ResultItemAdapter resultItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        setupResultItemList();
        setupPresenter();
    }

    @Override
    public void showSelectedResults(List<ResultItem> resultItems) {
        Log.d(C.LOG_TAG, "Results to be shown: " + resultItems.size());
        resultItemAdapter.updateItems(resultItems);
    }

    private void setupPresenter() {
        filterPresenter = new FilterPresenterImpl(this);
    }

    private void setupResultItemList() {
        resultItemList = (RecyclerView) findViewById(R.id.item_result_list);
        resultItemList.setLayoutManager(new LinearLayoutManager(this));
        resultItemAdapter = new ResultItemAdapter(new ArrayList<ResultItem>());
        resultItemList.setAdapter(resultItemAdapter);
    }
}
