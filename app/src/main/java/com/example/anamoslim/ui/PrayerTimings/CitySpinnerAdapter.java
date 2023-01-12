package com.example.anamoslim.ui.PrayerTimings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.anamoslim.R;
import com.example.anamoslim.data.pojo.City;

import java.util.List;
import java.util.Objects;

public class CitySpinnerAdapter extends ArrayAdapter<City> {
    List<City> cities;

    public CitySpinnerAdapter(@NonNull Context context, List<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return intView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return intView(position, convertView, parent);
    }

    @Nullable
    @Override
    public City getItem(int position) {
        return cities.get(position);
    }

    private View intView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_city_list
                    , parent, false);
            TextView cityText = convertView.findViewById(R.id.city);
            TextView countryCodeText = convertView.findViewById(R.id.country_code);
            cityText.setText(Objects.requireNonNull(getItem(position)).getName());
            countryCodeText.setText(Objects.requireNonNull(getItem(position)).getCountry());

        }
        return convertView;
    }
}
