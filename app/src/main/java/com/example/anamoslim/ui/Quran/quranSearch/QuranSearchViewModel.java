package com.example.anamoslim.ui.Quran.quranSearch;

import android.content.Context;

import com.example.anamoslim.data.database.QuranDataBase;
import com.example.anamoslim.data.pojo.Aya;

import java.util.ArrayList;

public class QuranSearchViewModel {


    public ArrayList<Aya> GetAyaByWord(Context context, String keyword) {
        return (ArrayList<Aya>) QuranDataBase.getInstance(context).quranDao().GetAyaBySubText(keyword);
    }
}
