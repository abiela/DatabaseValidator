package com.databasevalidator.databasevalidator.filter.view;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.databasevalidator.databasevalidator.R;
import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;
import com.databasevalidator.databasevalidator.filter.model.ResultItem;
import com.databasevalidator.databasevalidator.filter.presenter.FilterPresenterImpl;
import com.databasevalidator.databasevalidator.filter.presenter.IFilterPresenter;
import com.databasevalidator.databasevalidator.filter.utils.C;
import com.databasevalidator.databasevalidator.filter.view.other.ClickListener;
import com.databasevalidator.databasevalidator.filter.view.other.FindAbovePercentageRateFragmentDialog;
import com.databasevalidator.databasevalidator.filter.view.other.FindBelowPercentageRateFragmentDialog;
import com.databasevalidator.databasevalidator.filter.view.other.FindInRangeFragmentDialog;
import com.databasevalidator.databasevalidator.filter.view.other.FindLeastSimilarFragmentDialog;
import com.databasevalidator.databasevalidator.filter.view.other.FindMaxFragmentDialog;
import com.databasevalidator.databasevalidator.filter.view.other.FindMinFragmentDialog;
import com.databasevalidator.databasevalidator.filter.view.other.FindMostSimilarFragmentDialog;
import com.databasevalidator.databasevalidator.filter.view.other.SortFragmentDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilterActivity extends AppCompatActivity implements IFilterViewInterface {

    private IFilterPresenter filterPresenter;
    private RecyclerView resultItemList;
    private ResultItemAdapter resultItemAdapter;
    private ClickListener dataClickListener;

    @Bind(R.id.item_result_amount) TextView resultAmountTextView;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.database_action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.database_action_show_all: {
                filterPresenter.onDataExploringTypeSelected(new DataSelector.AllData(null));
                return true;
            }

            case R.id.database_action_sort: {
                SortFragmentDialog fragmentDialog = new SortFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "sort");
                return true;
            }

            case R.id.database_action_find_max: {
                FindMaxFragmentDialog fragmentDialog = new FindMaxFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "dialog_max");
                return true;
            }

            case R.id.database_action_find_min: {
                FindMinFragmentDialog fragmentDialog =  new FindMinFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "dialog_min");
                return true;
            }

            case R.id.database_action_find_most_similar: {
                FindMostSimilarFragmentDialog fragmentDialog = new FindMostSimilarFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "most_similar");
                return true;
            }

            case R.id.database_action_find_least_similar: {
                FindLeastSimilarFragmentDialog fragmentDialog = new FindLeastSimilarFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "least_similar");
                return true;
            }

            case R.id.database_action_find_above_similarity: {
                FindAbovePercentageRateFragmentDialog fragmentDialog = new FindAbovePercentageRateFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "find_above");
                return true;
            }

            case R.id.database_action_find_below_similarity: {
                FindBelowPercentageRateFragmentDialog fragmentDialog = new FindBelowPercentageRateFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "find_below");
                return true;
            }

            case R.id.database_action_find_in_range: {
                FindInRangeFragmentDialog fragmentDialog = new FindInRangeFragmentDialog();
                fragmentDialog.setClickListener(dataClickListener);
                fragmentDialog.show(getFragmentManager(), "find_in_range");
                return true;
            }

            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    @Override
    public void showSelectedResults(List<ResultItem> resultItems) {
        Log.d(C.LOG_TAG, "Results to be shown: " + resultItems.size());
        resultItemAdapter.updateItems(resultItems);
        changeResultAmount(resultItems.size());
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

    private void changeResultAmount(int resultAmount) {
        resultAmountTextView.setText(getString(R.string.activity_filter_amount, resultAmount));
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
