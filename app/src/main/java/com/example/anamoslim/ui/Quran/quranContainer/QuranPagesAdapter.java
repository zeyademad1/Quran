package com.example.anamoslim.ui.Quran.quranContainer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.anamoslim.ui.Quran.quranPage.QuranPageFragment;

public class QuranPagesAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 604;

    public QuranPagesAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // As The number starts with 0 we reversed the equation to start from the end
        return  new QuranPageFragment(NUM_PAGES - position);
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
