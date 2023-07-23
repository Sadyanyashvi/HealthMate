package com.example.healthmate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FruitFragment extends Fragment {



    public FruitFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruit, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button foodButton = view.findViewById(R.id.food_cal);
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click here
                navigateToAnotherActivity();
            }
        });
        return view;
    }

    private void navigateToAnotherActivity() {
        Intent intent = new Intent(getActivity(), food_calories.class);
        startActivity(intent);
    }
}