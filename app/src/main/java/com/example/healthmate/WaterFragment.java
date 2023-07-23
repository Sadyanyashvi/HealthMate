package com.example.healthmate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class WaterFragment extends Fragment {



    public WaterFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_water, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button waterButton = view.findViewById(R.id.water_cal);
        waterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click here
                navigateToAnotherActivity();
            }
        });

        return view;
    }

    private void navigateToAnotherActivity() {
        Intent intent = new Intent(getActivity(), watertrackActivity.class);
        startActivity(intent);
    }
}