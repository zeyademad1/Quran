package com.example.anamoslim.ui.Quran.quranContainer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.anamoslim.R;

public class QuranContainerFragment extends Fragment {

    ViewPager2 viewPager;
    QuranPagesAdapter quranAdapter;
    QuranContainerFragmentArgs args;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        args = QuranContainerFragmentArgs.fromBundle(requireArguments());
        return inflater.inflate(R.layout.fragment_quran_container, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quranAdapter = new QuranPagesAdapter(getActivity());
        viewPager = view.findViewById(R.id.quran_pager);
        viewPager.setAdapter(quranAdapter);
        viewPager.setCurrentItem(604 - args.getStartPage());

    }
}