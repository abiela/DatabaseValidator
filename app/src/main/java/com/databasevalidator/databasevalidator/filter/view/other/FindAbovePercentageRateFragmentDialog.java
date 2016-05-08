package com.databasevalidator.databasevalidator.filter.view.other;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.databasevalidator.databasevalidator.R;
import com.databasevalidator.databasevalidator.filter.data_explore.DataSelector;

/**
 * @author arek.biela@estimote.com (Arek Biela).
 */
public class FindAbovePercentageRateFragmentDialog extends DialogFragment {

    private Button findAbovePercentageRateButton;
    private EditText leafLengthValue, leafWidthValue, petalLengthValue, petalWidthValue, percentageRateValue;
    private TextView percentageRateText;
    private ClickListener onClickListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_load_element, container, false);

        leafLengthValue = (EditText) view.findViewById(R.id.fragment_dialog_leaf_length_value);
        leafWidthValue = (EditText) view.findViewById(R.id.fragment_dialog_leaf_width_value);
        petalLengthValue = (EditText) view.findViewById(R.id.fragment_dialog_petal_length_value);
        petalWidthValue = (EditText) view.findViewById(R.id.fragment_dialog_petal_width_value);
        percentageRateValue = (EditText) view.findViewById(R.id.fragment_dialog_number_of_elements_value);
        percentageRateText = (TextView) view.findViewById(R.id.fragment_dialog_last_value_text);

        percentageRateText.setText(getString(R.string.percentage_rate));
        findAbovePercentageRateButton = (Button) view.findViewById(R.id.fragment_dialog_button);
        findAbovePercentageRateButton.setText(getString(R.string.database_action_find_least_similar));
        findAbovePercentageRateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double[] loadedElementValues = new double[4];
                loadedElementValues[0] = Double.valueOf(leafLengthValue.getText().toString());
                loadedElementValues[1] = Double.valueOf(leafWidthValue.getText().toString());
                loadedElementValues[2] = Double.valueOf(petalLengthValue.getText().toString());
                loadedElementValues[3] = Double.valueOf(petalWidthValue.getText().toString());
                float elementsNumber = Float.valueOf(percentageRateValue.getText().toString());
                DataSelector dataSelector = new DataSelector.FindAbovePercentageRateSelector(null, loadedElementValues, elementsNumber / 100);
                onClickListener.onSelected(dataSelector);
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }

    public void setClickListener(ClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
