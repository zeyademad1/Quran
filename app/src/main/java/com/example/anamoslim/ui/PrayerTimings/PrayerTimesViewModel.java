package com.example.anamoslim.ui.PrayerTimings;


import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.anamoslim.data.CitiesProvider.CitiesProvider;
import com.example.anamoslim.data.Networking.PrayersRetrofit;
import com.example.anamoslim.data.pojo.City;
import com.example.anamoslim.data.pojo.PrayerTiming.PrayerApiResponse;
import com.example.anamoslim.data.pojo.PrayerTiming.Timing;
import com.example.anamoslim.data.pojo.PrayerTiming.Timings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrayerTimesViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Timing>> PrayerTiming;
    private final MutableLiveData<City> currentCity;

    public PrayerTimesViewModel() {
        PrayerTiming = new MutableLiveData<>();
        currentCity = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<Timing>> getPrayerTiming() {
        return PrayerTiming;
    }

    public void setPrayerTiming( City city, int day, int month, int year) {
        getPrayer(city.getName(), city.getCountry(), 5, month, year)
                .enqueue(new Callback<PrayerApiResponse>() {
                    @Override
                    public void onResponse(Call<PrayerApiResponse> call, Response<PrayerApiResponse> response) {
                        Timings timings = response.body().getData().get(1).getTimings();
                        ArrayList<Timing> time = convertFromTimingsToTiming(timings);
                        PrayerTiming.setValue(time);

                    }

                    @Override
                    public void onFailure(Call<PrayerApiResponse> call, Throwable t) {

                    }
                });
    }

    public Call<PrayerApiResponse> getPrayer(String city, String country,
                                             int method, int month, int year) {
        return PrayersRetrofit.getAPI().getPrayers(city, country, method, month, year);
    }

    public ArrayList<Timing> convertFromTimingsToTiming(Timings timings) {
        ArrayList<Timing> res = new ArrayList<>();
        res.add(new Timing("Fajr", timings.getFajr()));
        res.add(new Timing("Dhuhr", timings.getDhuhr()));
        res.add(new Timing("Asr", timings.getAsr()));
        res.add(new Timing("Maghrib", timings.getMaghrib()));
        res.add(new Timing("Isha", timings.getIsha()));
        return res;
    }

    public List<City> getcities(Context context) throws IOException {
        return CitiesProvider.GetCities(context);
    }

    public void setCurrentCity(Context context, int position) throws IOException {
        currentCity.setValue(getcities(context).get(position));

    }

    public MutableLiveData<City> getCurrentCity() {
        return currentCity;
    }
}
