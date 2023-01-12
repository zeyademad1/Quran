package com.example.anamoslim.ui.Azkar.azkarList;

import android.app.Application;
import com.example.anamoslim.data.azkarProviders.azkarTypesProvider;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.anamoslim.data.pojo.Zekr;

import java.io.IOException;
import java.util.ArrayList;

public class AzkarListViewModel extends AndroidViewModel {

    public AzkarListViewModel(@NonNull Application application) {
        super(application);
    }

    public ArrayList<Zekr> getAzkar(String zekerType) {
        try {
            return azkarTypesProvider.GetAzkarByType(getApplication(), zekerType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
