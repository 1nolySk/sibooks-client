package com.dev.kedaiit.sibooks.ui.penerbit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dev.kedaiit.sibooks.R;
import com.dev.kedaiit.sibooks.ui.kategori.KategoriViewModel;

public class PenerbitFragment extends Fragment {

    private PenerbitViewModel penerbitViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        penerbitViewModel =
                ViewModelProviders.of(this).get(PenerbitViewModel.class);
        View root = inflater.inflate(R.layout.fragment_penerbit, container, false);
        final TextView textView = root.findViewById(R.id.text_penerbit);
        penerbitViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}