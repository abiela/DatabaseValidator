package com.databasevalidator.databasevalidator.filter.view.other;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.databasevalidator.databasevalidator.R;
import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;
import com.databasevalidator.databasevalidator.filter.model.IrisResultItem;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class SortFragmentDialog extends DialogFragment {

    private String[] fieldsName;
    private Spinner spinner;
    private Button findMinButton;
    private ClickListener onClickListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fieldsName = new String[IrisResultItem.class.getFields().length - 2];
        for (int i = 1; i < IrisResultItem.class.getFields().length - 1; i++) {
            fieldsName[i - 1] = IrisResultItem.class.getFields()[i].getName();
        }
        setCancelable(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_spinner_value, container, false);

        spinner = (Spinner) view.findViewById(R.id.fragment_dialog_spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, fieldsName);
        spinner.setAdapter(arrayAdapter);

        findMinButton = (Button) view.findViewById(R.id.fragment_dialog_button);
        findMinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSelector dataSelector = new DataSelector.SortSelector(fieldsName[spinner.getSelectedItemPosition()]);
                onClickListener.onSelected(dataSelector);
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void show(android.app.FragmentManager manager, String tag) {
        super.show(manager, tag);
    }

    public void setClickListener(ClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
