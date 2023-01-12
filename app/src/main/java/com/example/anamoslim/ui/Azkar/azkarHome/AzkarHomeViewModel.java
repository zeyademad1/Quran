package com.example.anamoslim.ui.Azkar.azkarHome;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import  com.example.anamoslim.data.azkarProviders.azkarTypesProvider;
import com.example.anamoslim.data.pojo.ZekrTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class AzkarHomeViewModel  extends ViewModel {

    HashSet<ZekrTypes> getAzkarTypes(Context context){
        try {
            return azkarTypesProvider.getAzkarTypes(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    }


