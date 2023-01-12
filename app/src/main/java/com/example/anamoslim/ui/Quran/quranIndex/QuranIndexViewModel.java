package com.example.anamoslim.ui.Quran.quranIndex;

import androidx.lifecycle.ViewModel;

import com.example.anamoslim.data.utils.IndexTabsUtilities;

public class QuranIndexViewModel extends ViewModel {

    // To Get The Tab Name
    private int[] tabs;

    public QuranIndexViewModel()  {
        tabs = IndexTabsUtilities.QURAN_INDEX_TABS;
    }

    // get the specific tab
    public int GetTabAt(int position) {
        return tabs[position];
    }
}
