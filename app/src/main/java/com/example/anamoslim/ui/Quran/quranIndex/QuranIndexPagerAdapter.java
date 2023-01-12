package com.example.anamoslim.ui.Quran.quranIndex;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.anamoslim.data.utils.IndexTabsUtilities;
import com.example.anamoslim.ui.soraList.SoraListFragment;

public class QuranIndexPagerAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;
    public QuranIndexPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return  new SoraListFragment(IndexTabsUtilities.QuranTabs.Sora);

            case 1:
                return new SoraListFragment(IndexTabsUtilities.QuranTabs.Jozz);

            case 2:
                return new SoraListFragment(IndexTabsUtilities.QuranTabs.Page);

            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }
}
