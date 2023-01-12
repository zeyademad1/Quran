package com.example.anamoslim.ui.soraList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.anamoslim.data.database.QuranDao;
import com.example.anamoslim.data.database.QuranDataBase;
import com.example.anamoslim.data.pojo.Jozz;
import com.example.anamoslim.data.pojo.Sora;
import com.example.anamoslim.data.utils.IndexTabsUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SoraListViewModel extends AndroidViewModel {

    public SoraListViewModel(@NonNull Application application) {
        super(application);
    }

    public ArrayList<Sora> GetAllSoras() {
        ArrayList<Sora> sora = new ArrayList<>();
        for (int i = 1; i <= 114; i++) {
            sora.add(QuranDataBase.getInstance(getApplication()).quranDao().GetSoraByNumber(i));
        }
        return sora;
    }


    public ArrayList<Jozz> GetAllAjzaa() {
        QuranDao dao = QuranDataBase.getInstance(getApplication()).quranDao();
        ArrayList<Jozz> ajzaa = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            ajzaa.add(dao.GetJozzByNUmber(i));

        }
        return ajzaa;
    }

    public List<Integer> getPages() {
        return IntStream.range(1, 604).boxed().collect(Collectors.toList());
    }

    public List<?> ProvideIndexList(IndexTabsUtilities.QuranTabs current) {
        switch (current) {
            case Jozz:
                return GetAllAjzaa();

            case Sora:
                return GetAllSoras();

            case Page:
                return getPages();
            default:
                return null;
        }

    }

}
