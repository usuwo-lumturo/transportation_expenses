package com.example.transportationexpenses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IcHistoryTableMakeAdapter extends RecyclerView.Adapter<IcHistoryTableMakeAdapter.ViewHolder> {

    private List<IcHistory> icHistoryList;

    public IcHistoryTableMakeAdapter(List<IcHistory> icHistories) {
        this.icHistoryList = icHistories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_ic_history_table_make, parent, false);
        return new IcHistoryTableMakeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return icHistoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
