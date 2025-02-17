package com.guercifzone.tafsirahlam.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guercifzone.tafsirahlam.R;

public class DataItemViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTextView, descriptionTextView;
    public DataItemViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
    }
}
