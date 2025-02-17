package com.guercifzone.tafsirahlam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guercifzone.tafsirahlam.DataBase.DataItem;
import com.guercifzone.tafsirahlam.R;

import java.util.List;

public class DataItemAdapter extends RecyclerView.Adapter<DataItemViewHolder> {
    private List<DataItem> dataItemList;

    public DataItemAdapter(List<DataItem> dataItems) {
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public DataItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new DataItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataItemViewHolder holder, int position) {
DataItem dataItem = dataItemList.get(position);
holder.nameTextView.setText(dataItem.name);
holder.descriptionTextView.setText(dataItem.description);
    }

    @Override
    public int getItemCount() {
        return dataItemList.size();
    }
    public void updateData(List<DataItem> newData){
        dataItemList = newData;
        notifyDataSetChanged();
    }
}
