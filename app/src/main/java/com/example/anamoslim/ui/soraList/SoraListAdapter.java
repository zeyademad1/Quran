package com.example.anamoslim.ui.soraList;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anamoslim.R;
import com.example.anamoslim.data.pojo.Jozz;
import com.example.anamoslim.data.pojo.Sora;
import com.example.anamoslim.ui.Quran.quranIndex.QuranIndexFragmentDirections;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class SoraListAdapter extends RecyclerView.Adapter<SoraListAdapter.SoraListViewHolder> {
    List<?> index;
    Fragment fragment;

    public SoraListAdapter(List<?> index, Fragment fragment) {
        this.index = index;
        this.fragment = fragment;
    }


    @NonNull
    @Override
    public SoraListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SoraListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sora, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SoraListViewHolder holder, int position) {
        if (index.get(position) instanceof Sora) {
            holder.onBind((Sora) index.get(position));
        } else if (index.get(position) instanceof Jozz) {
            holder.onBind((Jozz) index.get(position));
        } else if (index.get(position) instanceof Integer) {
            holder.onBind((Integer) index.get(position));

        }
    }


    @Override
    public int getItemCount() {
        return index.size();
    }

    class SoraListViewHolder extends RecyclerView.ViewHolder {
        TextView soraName, soraNumber, from, to, wordFrom, wordTo;
        Sora Soras;

        public SoraListViewHolder(@NonNull View itemView) {
            super(itemView);
            soraName = itemView.findViewById(R.id.tv_sora_name);
            soraNumber = itemView.findViewById(R.id.tv_sora_number);
//            from = itemView.findViewById(R.id.sora_start);
//            to = itemView.findViewById(R.id.sora_end);
//            wordFrom = itemView.findViewById(R.id.word_from);
//            wordTo = itemView.findViewById(R.id.word_to);
        }

        void onBind(Sora Soras) {

            // Perfect transaction
            NumberFormat nf = NumberFormat.getInstance(new Locale("ar", "en"));

//            wordTo.setVisibility(View.VISIBLE);

            this.Soras = Soras;
            soraName.setText(Soras.getArabicName());
            soraNumber.setText((  "-" +nf.format(Soras.getSoraNumber())  ));
//            from.setText(nf.format(Soras.getStartPage()));
//            to.setText(nf.format(Soras.getEndPage()));
            itemView.setOnClickListener(v -> NavHostFragment.findNavController(fragment)
                    .navigate(QuranIndexFragmentDirections.actionQuranIndexFragmentToQuranFragment(Soras.getStartPage())));
        }

        @SuppressLint("DefaultLocale")
        void onBind(Jozz jozz) {
         // Done Successfully Alone<!!!!!!!>
            NumberFormat nf = NumberFormat.getInstance(new Locale("ar", "en"));

//            wordTo.setVisibility(View.VISIBLE);
            soraName.setText((fragment.getString(R.string.jozz) + ":" + nf.format(jozz.getJozzNumber())));
            soraNumber.setText("");
//            from.setText(String.format("%d", jozz.getStartPage()));
//            to.setText(String.format("%d", jozz.getEndPage()));
            itemView.setOnClickListener(v -> NavHostFragment.findNavController(fragment)
                    .navigate(QuranIndexFragmentDirections.actionQuranIndexFragmentToQuranFragment(jozz.getStartPage())));
        }

        void onBind(Integer page) {
            NumberFormat nf = NumberFormat.getInstance(new Locale("ar", "en"));
            soraName.setText((fragment.getString(R.string.page) + ": " + nf.format(page)));
            soraNumber.setVisibility(View.GONE);
//            from.setVisibility(View.GONE);
//            wordTo.setVisibility(View.GONE);
//            wordFrom.setVisibility(View.GONE);
//            from.setText("");
//            to.setVisibility(View.GONE);
//            to.setText("");
//            // Perfect Transaction

            itemView.setOnClickListener(v -> NavHostFragment.findNavController(fragment)
                    .navigate(QuranIndexFragmentDirections.actionQuranIndexFragmentToQuranFragment(page)));

        }
    }
}
