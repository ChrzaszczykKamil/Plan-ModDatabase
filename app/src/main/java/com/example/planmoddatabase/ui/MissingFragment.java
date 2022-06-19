package com.example.planmoddatabase.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.planmoddatabase.R;
import com.example.planmoddatabase.adaptes.AdapterUnknown;
import com.example.planmoddatabase.databinding.FragmentMissingBinding;

import java.util.ArrayList;

public class MissingFragment extends Fragment {

    private FragmentMissingBinding binding;
    ListView myList;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        binding = FragmentMissingBinding.inflate(inflater, parent, false);
        View view = binding.getRoot();
        myList =  view.findViewById(R.id.ListViewOfMissingPlans);

        ArrayList<String> unknownPlans = new ArrayList<>();
        //Do this in a loop over unknown plans
        unknownPlans.add("Plan: ULtracite Left Arm");
        unknownPlans.add("Recipe: Healing Salve (Mire)");
        unknownPlans.add("Plan: ULtracite Left Leg");
        unknownPlans.add("Plan: ULtracite Right Arm");
        unknownPlans.add("Plan: ULtracite Right Leg");
        unknownPlans.add("Plan: ULtracite Torso");
        unknownPlans.add("Plan: TEMP PLAN #1");
        unknownPlans.add("Plan: TEMP PLAN #2");
        unknownPlans.add("Plan: TEMP PLAN #3");
        unknownPlans.add("Plan: TEMP PLAN #4");
        unknownPlans.add("Plan: TEMP PLAN #5");
        unknownPlans.add("Plan: TEMP PLAN #6");
        unknownPlans.add("Plan: TEMP PLAN #7");
        unknownPlans.add("Plan: TEMP PLAN #8");
        unknownPlans.add("Plan: TEMP PLAN #9");
        unknownPlans.add("Plan: TEMP PLAN #10");

        myList.setAdapter(new AdapterUnknown(unknownPlans, view.getContext()) );

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //TODO: Save changes and update the list
        System.out.println("CLEAR");
        binding = null;
    }
}