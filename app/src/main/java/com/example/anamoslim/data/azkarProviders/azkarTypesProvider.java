package com.example.anamoslim.data.azkarProviders;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.anamoslim.data.pojo.Zekr;
import com.example.anamoslim.data.pojo.ZekrTypes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class azkarTypesProvider {

    private static ArrayList<Zekr> GetAllZekr(Context context) throws IOException {
        InputStream azkarFile = context.getAssets().open("azkar/azkar.json");
        int size = azkarFile.available();
        byte[] bytes = new byte[size];
        azkarFile.read(bytes);
        azkarFile.close();
        String azkarString = new String(bytes, StandardCharsets.UTF_8);
        Gson gson = new Gson();
        ArrayList<Zekr> azkar = gson.fromJson(azkarString, new TypeToken<List<Zekr>>() {
        }.getType());
        return azkar;
    }

    public static ArrayList<Zekr> GetAzkarByType(Context context , String zekrType) throws IOException {

            return  GetAllZekr(context)
                    .stream()
                    .filter(zekr -> zekrType.equals(zekr.getCategory()))
                    .collect(Collectors.toCollection(ArrayList::new));

    }
    public static HashSet<ZekrTypes> getAzkarTypes(Context context) throws IOException {
        return GetAllZekr(context)
                .stream()
                .map(zekr -> new ZekrTypes(zekr.getCategory()))
                .collect(Collectors.toCollection(HashSet::new));
    }

}
