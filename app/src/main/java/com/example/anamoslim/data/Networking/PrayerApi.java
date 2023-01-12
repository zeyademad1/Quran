package com.example.anamoslim.data.Networking;

import com.example.anamoslim.data.pojo.PrayerTiming.PrayerApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PrayerApi {

    // http://api.aladhan.com/v1/calendarByCity?city=London&country=United Kingdom&method=2&month=04&year=2017

    @GET("/calendarByCity")
    Call<PrayerApiResponse> getPrayers(@Query("city") String city,
                                       @Query("country") String country,
                                       @Query("method") int method,
                                       @Query("month") int month,
                                       @Query("year") int year);
}
