package com.aman1.feelitsayit.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.aman1.feelitsayit.R;
import com.aman1.feelitsayit.model.Feeling;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeelingFragment extends Fragment {

    private static final String TAG = "FeelingFragment";
    private FeelingFragment feelingFragment;

    private Feeling feeling;

    private EditText entityName;
    private EditText feelingDetails;
    private Button feelingDate;




    public FeelingFragment() {
        // Required empty public constructor
    }

    public FeelingFragment getInstance(){
        if (feelingFragment == null){
            feelingFragment = new FeelingFragment();
        }
        return feelingFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        feeling = new Feeling();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_feeling, container, false);

        entityName = v.findViewById(R.id.entity_name);
        feelingDetails = v.findViewById(R.id.feeling_details);
        feelingDate = v.findViewById(R.id.feeling_date);

        entityName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                feeling.setEntityName(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        feelingDetails.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                feeling.setFeelingDetails(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        feelingDate.setText(feeling.getDate().toString());
        feelingDate.setEnabled(false);

        return v;
    }

}
