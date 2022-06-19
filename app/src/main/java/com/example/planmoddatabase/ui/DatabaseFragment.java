package com.example.planmoddatabase.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.planmoddatabase.R;
import com.example.planmoddatabase.databinding.FragmentDatabaseBinding;

public class DatabaseFragment extends Fragment {

    private FragmentDatabaseBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        binding = FragmentDatabaseBinding.inflate(inflater, parent, false);
        View view = binding.getRoot();
        Button button = view.findViewById(R.id.weapons);
//        button.setOnClickListener(v -> {
//            Intent intent = new Intent(getActivity(), DatabaseListActivity.class);
//            startActivity(intent);
//        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}