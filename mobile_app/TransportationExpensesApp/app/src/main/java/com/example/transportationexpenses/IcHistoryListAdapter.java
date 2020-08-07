package com.example.transportationexpenses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IcHistoryListAdapter extends RecyclerView.Adapter<IcHistoryListAdapter.ViewHolder> {

    private List<IcHistory> icHistoryList;

    IcHistoryListAdapter(List<IcHistory> icHistories) {
        this.icHistoryList = icHistories;
    }

    @NonNull
    @Override
    public IcHistoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ic_history, parent, false);
        return new IcHistoryListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IcHistoryListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return icHistoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
