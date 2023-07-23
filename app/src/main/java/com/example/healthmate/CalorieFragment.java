package com.example.healthmate;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CalorieFragment extends Fragment {



    public CalorieFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calorie, container, false);

        Button buttonNavigate = view.findViewById(R.id.calorie_cal);
        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click here
                navigateToAnotherActivity();
            }
        });
        return view;
    }
    private void navigateToAnotherActivity() {
        Intent intent = new Intent(getActivity(), cal_recommendation.class);
        startActivity(intent);
    }
}