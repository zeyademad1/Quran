package com.example.anamoslim.ui.Quran.quranPage;

import android.content.Context;

import com.example.anamoslim.data.PagesManager;

public class QuranViewModel {
    public int GetQuranImageByPageNumber(Context context , int pageNumber){
        return PagesManager.GetQuranImageByPageNumber(context , pageNumber);
    }
}
