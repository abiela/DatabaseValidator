package com.databasevalidator.databasevalidator.filter.view;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.databasevalidator.databasevalidator.R;
import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;
import com.databasevalidator.databasevalidator.filter.model.ResultItem;
import com.databasevalidator.databasevalidator.filter.presenter.FilterPresenterImpl;
import com.databasevalidator.databasevalidator.filter.presenter.IFilterPresenter;
import com.databasevalidator.databasevalidator.filter.utils.C;
import com.databasevalidator.databasevalidator.filter.view.other.ClickListener;
import com.databasevalidator.databasevalidator.filter.view.other.FindMaxFragmentDialog;
import com.databasevalidator.databasevalidator.filter.view.other.FindMinFragmentDialog;
import com.databasevalidator.databasevalidator.filter.view.other.SortFragmentDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilterActivity extends AppCompatActivity implements IFilterViewInterface {

    private IFilterPresenter filterPresenter;
    private RecyclerView resultItemList;
    private ResultItemAdapter resultItemAdapter;
    private ClickListener dataClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ButterKnife.bind(this);
        setupResultItemList();
        setupPresenter();
        setupClickListener();
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

    @OnClick ({R.id.activity_filter_find_min_button, R.id.activity_filter_find_max_button, R.id.activity_filter_sort_button})
    void onActionClick(View view) {

        switch (view.getId()) {
            case R.id.activity_filter_find_min_button: {
                FindMinFragmentDialog fragmentDialog =  new FindMinFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "dialog_min");
                break;
            }

            case R.id.activity_filter_find_max_button: {
                FindMaxFragmentDialog fragmentDialog = new FindMaxFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "dialog_max");
                break;
            }

            case R.id.activity_filter_sort_button: {
                SortFragmentDialog fragmentDialog = new SortFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "sort");
                break;
            }
            default: {
                FindMinFragmentDialog fragmentDialog =  new FindMinFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "dialog_min");
                break;
            }
        }

    }

    private void setupClickListener() {
        dataClickListener = new ClickListener() {
            @Override
            public void onSelected(DataSelector dataSelector) {
                filterPresenter.onDataExploringTypeSelected(dataSelector);
            }
        };
    }
}
