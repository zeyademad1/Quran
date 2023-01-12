package com.example.anamoslim.ui.Quran.quranIndex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.anamoslim.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class QuranIndexFragment extends Fragment {

    TabLayout indexTabs;
    QuranIndexViewModel viewModel;
    QuranIndexPagerAdapter pagerAdapter;
    ViewPager2 pager;
    TextView search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran_index, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        indexTabs = view.findViewById(R.id.quran_index_tabs);
        search = view.findViewById(R.id.quran_search);
        pager = view.findViewById(R.id.quran_index_pager);
        pagerAdapter = new QuranIndexPagerAdapter(requireActivity());
        pager.setAdapter(pagerAdapter);
        viewModel = new ViewModelProvider(this).get(QuranIndexViewModel.class);
        new TabLayoutMediator(indexTabs, pager,
                (tab, position) -> tab.setText(viewModel.GetTabAt(position))
        ).attach();

        search.setOnClickListener(v -> NavHostFragment.findNavController(this)
                .navigate(QuranIndexFragmentDirections
                        .actionQuranIndexFragmentToQuranSearchFragment()));
    }
}