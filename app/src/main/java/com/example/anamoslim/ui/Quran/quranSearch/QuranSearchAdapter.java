package com.example.anamoslim.ui.Quran.quranSearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anamoslim.R;
import com.example.anamoslim.data.pojo.Aya;
import com.example.anamoslim.ui.Quran.quranIndex.QuranIndexFragmentDirections;

import java.util.ArrayList;

public class QuranSearchAdapter extends RecyclerView.Adapter<QuranSearchAdapter.QuranSearchViewHolder> {
    private ArrayList<Aya> aya = new ArrayList<>();
    private Fragment fragment ;

    public QuranSearchAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    public void setAya(ArrayList<Aya> aya) {
        this.aya = aya;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public QuranSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuranSearchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_quran_search, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuranSearchViewHolder holder, int position) {
        Aya a = aya.get(position);
        holder.onBind(a);
    }


    @Override
    public int getItemCount() {
        return aya == null ? 0 : aya.size();
    }

    class QuranSearchViewHolder extends RecyclerView.ViewHolder {
        Aya ayat;
        TextView sora_name, sora_number, aya_number, aya_content;

        public QuranSearchViewHolder(@NonNull View itemView) {
            super(itemView);
            sora_name = itemView.findViewById(R.id.sora_name);
            sora_number = itemView.findViewById(R.id.sora_no);
            aya_content = itemView.findViewById(R.id.aya_content);
            aya_number = itemView.findViewById(R.id.aya_number);
        }

        void onBind(Aya ayat) {
            this.ayat = ayat;
            sora_number.setText(String.format("سورة رقم: %s", ayat.getSora()));
            sora_name.setText(String.format("سورة: %s", ayat.getSora_name_ar()));
            aya_number.setText(String.format("آية رقم: %s", ayat.getAya_no()));
            aya_content.setText(ayat.getAya_text());
            itemView.setOnClickListener( v -> NavHostFragment
                    .findNavController(fragment)
                    .navigate(QuranSearchFragmentDirections.actionQuranSearchFragmentToQuranFragment(ayat.getPage())));

        }
    }
}
