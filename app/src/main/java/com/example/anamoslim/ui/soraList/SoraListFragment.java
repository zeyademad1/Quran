package com.example.anamoslim.ui.soraList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anamoslim.R;
import com.example.anamoslim.data.utils.IndexTabsUtilities;

public class SoraListFragment extends Fragment {
    private final IndexTabsUtilities.QuranTabs currentTab;
    SoraListViewModel viewModel;

    public SoraListFragment(IndexTabsUtilities.QuranTabs currentTab) {
        this.currentTab = currentTab;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sora_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new SoraListViewModel(requireActivity().getApplication());
        RecyclerView soraList = view.findViewById(R.id.sora_rv);
        soraList.setLayoutManager(new GridLayoutManager(getContext() , 2));
//        soraList.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        soraList.setAdapter(new SoraListAdapter(viewModel.ProvideIndexList(currentTab), this));
    }
}