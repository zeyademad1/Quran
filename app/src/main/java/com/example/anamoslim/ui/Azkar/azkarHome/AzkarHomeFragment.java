package com.example.anamoslim.ui.Azkar.azkarHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anamoslim.R;

public class AzkarHomeFragment extends Fragment {

    RecyclerView azkarList;
    AzkarHomeViewModel viewModel;
    AzkarHomeAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(AzkarHomeViewModel.class);
        adapter = new AzkarHomeAdapter(this);
        return inflater.inflate(R.layout.fragment_azkar_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        azkarList = view.findViewById(R.id.azkar_list_home);
        azkarList.setAdapter(adapter);
        azkarList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setAzkarTypes(viewModel.getAzkarTypes(getContext()));
    }
}
