package com.example.anamoslim.data.Networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrayersRetrofit {

    private static final String BASE_URL = "http://api.aladhan.com/v1/";
    private static Retrofit instance;
    private static PrayerApi api;



    public static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return instance;
    }


    public static PrayerApi getAPI() {
        if (api == null) {
            api = getInstance().create(PrayerApi.class);
        }
        return api;
    }
}
