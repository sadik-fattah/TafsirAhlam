package com.guercifzone.tafsirahlam.UIFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.guercifzone.tafsirahlam.JsonParser.Tafsir_5;
import com.guercifzone.tafsirahlam.R;

import java.util.List;

public class Tafsir5_Fragment extends Fragment {
    //حرف الجيم
    public Tafsir5_Fragment(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        LinearLayout linearLayout = root.findViewById(R.id.linearLayout);
        List<Tafsir_5.SectionGroupOne> sections = Tafsir_5.readJsonFile(requireContext());
        for (Tafsir_5.SectionGroupOne section : sections) {
            TextView titleTextView = new TextView(requireContext());
            titleTextView.setText(section.getTitle());
            titleTextView.setTextSize(18);
            titleTextView.setPadding(16, 16, 16, 8);

            // Create a TextView for the content
            TextView contentTextView = new TextView(requireContext());
            contentTextView.setText(section.getContent());
            contentTextView.setTextSize(14);
            contentTextView.setPadding(16, 8, 16, 16);

            // Add the TextViews to the LinearLayout
            linearLayout.addView(titleTextView);
            linearLayout.addView(contentTextView);
        }
        return root;
    }
}
