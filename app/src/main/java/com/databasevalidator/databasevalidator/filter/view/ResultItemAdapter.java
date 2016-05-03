package com.databasevalidator.databasevalidator.filter.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.databasevalidator.databasevalidator.R;
import com.databasevalidator.databasevalidator.filter.model.IrisResultItem;
import com.databasevalidator.databasevalidator.filter.model.ResultItem;
import com.databasevalidator.databasevalidator.filter.utils.C;

import java.util.List;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class ResultItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int IRIS_ITEM_RESULT = 0;

    private List<ResultItem> resultItemList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView firstName, surname;

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }

    public class IrisViewHolder extends RecyclerView.ViewHolder {

        public TextView leafLength, leafWidth, petalLength, petalWidth, className, similarityRate;

        public IrisViewHolder(View itemView) {
            super(itemView);

            leafLength = (TextView) itemView.findViewById(R.id.item_result_iris_leaf_length);
            leafWidth = (TextView) itemView.findViewById(R.id.item_result_iris_leaf_width);
            petalLength = (TextView) itemView.findViewById(R.id.item_result_iris_petal_length);
            petalWidth = (TextView) itemView.findViewById(R.id.item_result_iris_petal_width);
            className = (TextView) itemView.findViewById(R.id.item_result_iris_class_name);
            similarityRate = (TextView) itemView.findViewById(R.id.item_result_iris_similarity_rate);
        }
    }

    public ResultItemAdapter() {

    }

    public ResultItemAdapter(List<ResultItem> resultItemList) {
        this.resultItemList = resultItemList;
    }

    public void updateItems(List<ResultItem> resultItemList) {
        this.resultItemList.clear();
        this.resultItemList.addAll(resultItemList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return IRIS_ITEM_RESULT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case IRIS_ITEM_RESULT:
            default:{
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result_iris, parent, false);
                return new IrisViewHolder(itemView);
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d(C.LOG_TAG, "onBindViewHolder: ");
        if (holder instanceof IrisViewHolder) {
            Log.d(C.LOG_TAG, "onBindViewHolder: inside Iris");
            ((IrisViewHolder) holder).leafLength.setText(((IrisResultItem) resultItemList.get(position)).getLeafLength().toString());
            ((IrisViewHolder) holder).leafWidth.setText(((IrisResultItem) resultItemList.get(position)).getLeafWidth().toString());
            ((IrisViewHolder) holder).petalLength.setText(((IrisResultItem) resultItemList.get(position)).getPetalLength().toString());
            ((IrisViewHolder) holder).petalWidth.setText(((IrisResultItem) resultItemList.get(position)).getPetalWidth().toString());
            ((IrisViewHolder) holder).className.setText(((IrisResultItem) resultItemList.get(position)).getClassName());
        }
    }

    @Override
    public int getItemCount() {
        return resultItemList.size();
    }
}
