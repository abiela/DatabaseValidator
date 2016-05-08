package com.databasevalidator.databasevalidator.filter.model.agds;

import android.content.Context;
import android.util.Log;

import com.databasevalidator.databasevalidator.R;
import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;
import com.databasevalidator.databasevalidator.filter.model.DatabaseCallback;
import com.databasevalidator.databasevalidator.filter.model.DatabaseType;
import com.databasevalidator.databasevalidator.filter.model.IRepositoryInterface;
import com.databasevalidator.databasevalidator.filter.model.IrisResultItem;
import com.databasevalidator.databasevalidator.filter.model.ResultItem;
import com.databasevalidator.databasevalidator.filter.model.StudentResultItem;
import com.databasevalidator.databasevalidator.filter.utils.C;

import java.io.File;
import java.util.List;

import agds.AGDS;
import agds.RecordNode;
import agds.Sort;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class AgdsRepositoryImpl implements IRepositoryInterface {

    private AGDS agdsInstance;
    private Context context;
    private DatabaseCallback databaseCallback;

    public AgdsRepositoryImpl(Context context, DatabaseCallback databaseCallback) {
        this.context = context;
        this.databaseCallback = databaseCallback;
        agdsInstance = new AGDS();
        loadData();
    }

    @Override
    public void loadData() {
        agdsInstance.launchAGDSStructureFromFile(context.getResources().openRawResource(R.raw.iris_data));
    }

    @Override
    public List<ResultItem> getAllRecords() {
        List<RecordNode> allRecordsList = agdsInstance.findAll();
        return AgdsItemConverter.IRIS_CONVERTER.toResultItem(allRecordsList, false);
    }

    @Override
    public List<ResultItem> onDataSelectorTriggered(DataSelector dataSelector) {
        if (dataSelector instanceof DataSelector.AllData) {
            return getAllRecords();
        }

        else if (dataSelector instanceof DataSelector.MinSelector) {
            return getMin(dataSelector.getAttribute());
        }

        else if (dataSelector instanceof DataSelector.MaxSelector) {
            return getMax(dataSelector.getAttribute());
        }

        else if (dataSelector instanceof DataSelector.SortSelector) {
            return getSorted(dataSelector.getAttribute());
        }

        else if (dataSelector instanceof DataSelector.FindMostSimilarSelector) {
            return getMostSimilarElements(null, ((DataSelector.FindMostSimilarSelector) dataSelector).getLoadedElementValues(), ((DataSelector.FindMostSimilarSelector) dataSelector).getAmount());
        }

        else if (dataSelector instanceof DataSelector.FindLeastSimilarSelector) {
            return getLeastSimilarElements(null, ((DataSelector.FindLeastSimilarSelector) dataSelector).getLoadedElementValues(), ((DataSelector.FindLeastSimilarSelector) dataSelector).getAmount());
        }

        else if (dataSelector instanceof DataSelector.FindAbovePercentageRateSelector) {
            return getAboveSimiliratyRateElements(null, ((DataSelector.FindAbovePercentageRateSelector) dataSelector).getLoadedElementValues(), ((DataSelector.FindAbovePercentageRateSelector) dataSelector).getPercentageRate());
        }

        else if (dataSelector instanceof DataSelector.FindBelowPercentageRateSelector) {
            return getBelowSimilarityRateElements(null, ((DataSelector.FindBelowPercentageRateSelector) dataSelector).getLoadedElementValues(), ((DataSelector.FindBelowPercentageRateSelector) dataSelector).getPercentageRate());
        }

        else if (dataSelector instanceof DataSelector.InRangeSelector) {
            return getElementsInRange(dataSelector.getAttribute(), ((DataSelector.InRangeSelector) dataSelector).getMinValue(), ((DataSelector.InRangeSelector) dataSelector).getMaxValue());
        }

        return null;
    }

    @Override
    public List<ResultItem> getMin(String attributeName) {
        List<RecordNode> minRecordsList = agdsInstance.findAttributeMin(attributeName);
        return AgdsItemConverter.IRIS_CONVERTER.toResultItem(minRecordsList, false);
    }

    @Override
    public List<ResultItem> getMax(String attributeName) {
        List<RecordNode> maxRecordsList = agdsInstance.findAttributeMax(attributeName);
        return AgdsItemConverter.IRIS_CONVERTER.toResultItem(maxRecordsList, false);
    }

    @Override
    public List<ResultItem> getSorted(String attributeName) {
        List<RecordNode> maxRecordsList = agdsInstance.sortByAttribute(attributeName, Sort.DESCENDING);
        return AgdsItemConverter.IRIS_CONVERTER.toResultItem(maxRecordsList, false);
    }

    @Override
    public List<ResultItem> getMostSimilarElements(String attributeName, double[] values, int amount) {
        List<RecordNode> mostSimilarElements = agdsInstance.findMostSimilarElementsTotalWage(values, amount);
        return AgdsItemConverter.IRIS_CONVERTER.toResultItem(mostSimilarElements, true);
    }

    @Override
    public List<ResultItem> getLeastSimilarElements(String attributeName, double[] values, int amount) {
        List<RecordNode> leastSimilarElements = agdsInstance.findLeastSimilarElementsTotalWage(values, amount);
        return AgdsItemConverter.IRIS_CONVERTER.toResultItem(leastSimilarElements, true);
    }

    @Override
    public List<ResultItem> getAboveSimiliratyRateElements(String attributeName, double[] values, float percentageRate) {
        List<RecordNode> aboveSimilarityRateElements = agdsInstance.findAboveSimilarityRate(values, percentageRate);
        return AgdsItemConverter.IRIS_CONVERTER.toResultItem(aboveSimilarityRateElements, true);
    }

    @Override
    public List<ResultItem> getBelowSimilarityRateElements(String attributeName, double[] values, float percentageRate) {
        List<RecordNode> belowSimilarityRateElements = agdsInstance.findBelowSimilarityRate(values, percentageRate);
        return AgdsItemConverter.IRIS_CONVERTER.toResultItem(belowSimilarityRateElements, true);
    }

    @Override
    public List<ResultItem> getElementsInRange(String atrributeName, double minValue, double maxValue) {
        List<RecordNode> inRangeElements = agdsInstance.findInAttributeRange(atrributeName, minValue, maxValue);
        return AgdsItemConverter.IRIS_CONVERTER.toResultItem(inRangeElements, false);
    }
}
