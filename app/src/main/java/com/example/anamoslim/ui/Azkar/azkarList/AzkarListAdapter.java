package com.example.anamoslim.ui.Azkar.azkarList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anamoslim.R;
import com.example.anamoslim.data.pojo.Zekr;

import java.util.ArrayList;

public class AzkarListAdapter extends RecyclerView.Adapter<AzkarListAdapter.AzkarListViewHolder> {
    ArrayList<Zekr> zekr;

    @NonNull
    @Override
    public AzkarListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AzkarListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_azkar_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AzkarListViewHolder holder, int position) {
        holder.onBind(zekr.get(position));
    }

    @Override
    public int getItemCount() {
        return zekr == null ? 0 : zekr.size();
    }

    public void setZekr(ArrayList<Zekr> zekr) {
        this.zekr = zekr;
        notifyDataSetChanged();
    }

    class AzkarListViewHolder extends RecyclerView.ViewHolder {
        Zekr azkar;
        ImageView zekrImage;
        TextView zekrName;

        public AzkarListViewHolder(@NonNull View itemView) {
            super(itemView);
            zekrImage = itemView.findViewById(R.id.azkar_image);
            zekrName = itemView.findViewById(R.id.azkar_name);
        }

        void onBind(Zekr azkar) {
            this.azkar = azkar;
            zekrName.setText(azkar.getZekr());

        }
    }
}
