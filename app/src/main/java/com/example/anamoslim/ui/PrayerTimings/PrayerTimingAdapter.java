package com.example.anamoslim.ui.PrayerTimings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anamoslim.R;
import com.example.anamoslim.data.pojo.PrayerTiming.Timing;

import java.util.ArrayList;

public class PrayerTimingAdapter extends RecyclerView.Adapter<PrayerTimingAdapter.PrayerTimingViewHolder> {
    ArrayList<Timing> time;


    @NonNull
    @Override
    public PrayerTimingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PrayerTimingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pray, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PrayerTimingViewHolder holder, int position) {
        holder.onBind(time.get(position));
    }

    public void setTime(ArrayList<Timing> time) {
        this.time = time;
    }

    @Override
    public int getItemCount() {
        return time == null ? 0 : time.size();
    }

    class PrayerTimingViewHolder extends RecyclerView.ViewHolder {
        Timing timing;
        TextView prayName, prayTime;

        public PrayerTimingViewHolder(@NonNull View itemView) {
            super(itemView);
            prayName = itemView.findViewById(R.id.pray_name);
            prayTime = itemView.findViewById(R.id.pray_time);
        }

        void onBind(Timing timing) {
            this.timing = timing;
            prayName.setText(timing.getPrayName());
            prayTime.setText(timing.getPrayTime());
        }
    }
}
