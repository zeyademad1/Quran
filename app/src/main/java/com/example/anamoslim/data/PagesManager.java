package com.example.anamoslim.data;

import android.content.Context;
import android.icu.text.DecimalFormat;

public class PagesManager {

    public static  int GetQuranImageByPageNumber(Context context , int pageNumber){
        DecimalFormat format = new DecimalFormat("000");
        String drawableName = "page" + format.format(pageNumber);
        return context.getResources().getIdentifier(drawableName , "drawable" , context.getPackageName());
    }
}
