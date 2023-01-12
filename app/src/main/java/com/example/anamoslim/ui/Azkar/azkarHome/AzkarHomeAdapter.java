package com.example.anamoslim.ui.Azkar.azkarHome;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anamoslim.R;
import com.example.anamoslim.data.pojo.ZekrTypes;

import java.util.ArrayList;
import java.util.HashSet;

public class AzkarHomeAdapter extends RecyclerView.Adapter<AzkarHomeAdapter.AzkarHomeViewHolder> {
    ArrayList<ZekrTypes> zekrTypes = new ArrayList<>();
    Fragment fragment;

    public AzkarHomeAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    public void setAzkarTypes(HashSet<ZekrTypes> azkarTypes) {
        this.zekrTypes = new ArrayList<>(azkarTypes);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public AzkarHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AzkarHomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_azkar_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AzkarHomeViewHolder holder, int position) {
        holder.onBind(zekrTypes.get(position));
    }


    @Override
    public int getItemCount() {
        return zekrTypes == null ? 0 : zekrTypes.size();
    }

    class AzkarHomeViewHolder extends RecyclerView.ViewHolder {
        ZekrTypes zekr;
        TextView azkarName;
        ImageView azkarImage;

        public AzkarHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            azkarName = itemView.findViewById(R.id.azkar_name);
            azkarImage = itemView.findViewById(R.id.azkar_image);
        }
        void onBind(ZekrTypes zekr) {
            this.zekr = zekr;
            azkarName.setText(zekr.getZekrName());
            if (zekr.getZekrImage() != -1){
                azkarImage.setImageResource(zekr.getZekrImage());
        }
            itemView.setOnClickListener( v -> NavHostFragment.findNavController(fragment)
                    .navigate(AzkarHomeFragmentDirections
                            .actionAzkarHomeFragmentToAzkarListFragment(zekr.getZekrName())));
        }

    }
}
