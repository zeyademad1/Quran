package com.example.anamoslim.ui.Quran.quranSearch;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anamoslim.R;
import com.example.anamoslim.data.pojo.Aya;

import java.util.ArrayList;


public class QuranSearchFragment extends Fragment {
    QuranSearchViewModel viewModel;
    QuranSearchAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new QuranSearchViewModel();
        adapter = new QuranSearchAdapter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_quran_search , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText search = view.findViewById(R.id.quran_search);
        RecyclerView quranSearchResult = view.findViewById(R.id.quran_search_results);
        quranSearchResult.setAdapter(adapter);
        quranSearchResult.addItemDecoration(new DividerItemDecoration(getContext() , DividerItemDecoration.VERTICAL));
        quranSearchResult.setLayoutManager(new LinearLayoutManager(getContext()));

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<Aya> aya  = viewModel.GetAyaByWord(getContext()  , s.toString());
                adapter.setAya(aya);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(getContext() , "Operation Completed" , Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }

}