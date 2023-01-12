package com.example.anamoslim.ui.Quran.quranPage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.anamoslim.R;

public class QuranPageFragment extends Fragment {


    private ImageView quranIv;
    private QuranViewModel quranViewModel;
    private int pageNumber;

    public QuranPageFragment(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       quranViewModel = new QuranViewModel();
        return inflater.inflate(R.layout.fragment_page_quran, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quranIv = view.findViewById(R.id.quran_image);
        int image = quranViewModel.GetQuranImageByPageNumber(getContext() , pageNumber);
        quranIv.setImageResource(image);
    }
}