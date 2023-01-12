package com.example.anamoslim.ui.PrayerTimings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anamoslim.R;

import java.io.IOException;
import java.util.Calendar;
import java.util.Objects;

public class PrayerTimingFragment extends Fragment {

    private PrayerTimingAdapter adapter;
    private PrayerTimesViewModel viewModel;
    private DatePicker datePicker;
    private Spinner city;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        adapter = new PrayerTimingAdapter();
        viewModel = new ViewModelProvider(this).get(PrayerTimesViewModel.class);
        return inflater.inflate(R.layout.fragment_prayer_timing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView list = view.findViewById(R.id.pray_list);
        city = view.findViewById(R.id.city);
        try {
            city.setAdapter(new CitySpinnerAdapter(getContext(), viewModel.getcities(getContext())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    viewModel.setCurrentCity(getContext(), position);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(adapter);
        datePicker = view.findViewById(R.id.date_picker);
        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH),
                (view1, year, monthOfYear, dayOfMonth) -> {
                    viewModel.setPrayerTiming(Objects.requireNonNull(viewModel.getCurrentCity().getValue()), dayOfMonth, monthOfYear, year);
                });
        viewModel.getPrayerTiming().observe(getViewLifecycleOwner(), timings -> {
            adapter.setTime(timings);
        });


        viewModel.getCurrentCity().observe(getViewLifecycleOwner(), city -> {
            viewModel.setPrayerTiming(Objects.requireNonNull(city
            ), datePicker.getDayOfMonth(), datePicker.getMonth(), datePicker.getYear());
        });

    }
}
