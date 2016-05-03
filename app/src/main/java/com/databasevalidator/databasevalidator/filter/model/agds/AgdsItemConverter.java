package com.databasevalidator.databasevalidator.filter.model.agds;

import com.databasevalidator.databasevalidator.filter.model.IrisResultItem;
import com.databasevalidator.databasevalidator.filter.model.ResultItem;
import com.databasevalidator.databasevalidator.filter.model.ResultItemConverter;

import java.util.ArrayList;
import java.util.List;

import agds.RecordNode;
import agds.ValueNode;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class AgdsItemConverter {

    public static final ResultItemConverter<List<RecordNode>> IRIS_CONVERTER = new ResultItemConverter<List<RecordNode>>() {
        @Override
        public List<ResultItem> toResultItem(List<RecordNode> rawResult) {
            List<ResultItem> resultItemList = new ArrayList<>();

            for (RecordNode recordNode : rawResult) {
                List<ValueNode> valueNodeList = recordNode.getValueNodeList();
                IrisResultItem irisResultItem = new IrisResultItem(
                        valueNodeList.get(0).getValue(),
                        valueNodeList.get(1).getValue(),
                        valueNodeList.get(2).getValue(),
                        valueNodeList.get(3).getValue(),
                        recordNode.getClassNode().getClassName());
                resultItemList.add(irisResultItem);
            }
            return resultItemList;
        }
    };
}
