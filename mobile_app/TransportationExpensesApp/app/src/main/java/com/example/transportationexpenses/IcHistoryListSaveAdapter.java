package com.example.transportationexpenses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IcHistoryListSaveAdapter extends RecyclerView.Adapter<IcHistoryListSaveAdapter.ViewHolder> {

    private List<IcHistory> icHistoryList;

    public IcHistoryListSaveAdapter(List<IcHistory> icHistories) {
        this.icHistoryList = icHistories;
    }

    @NonNull
    @Override
    public IcHistoryListSaveAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_ic_history_save, parent, false);
        return new IcHistoryListSaveAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IcHistoryListSaveAdapter.ViewHolder holder, int position) {
        holder.dateText.setText(icHistoryList.get(position).getDate());
        holder.transportationText.setText(icHistoryList.get(position).getTransportation());
        holder.stationsText.setText(icHistoryList.get(position).getBoardingStation());
        holder.fareText.setText(icHistoryList.get(position).getFare());
    }

    @Override
    public int getItemCount() {
        return icHistoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView dateText;
        private TextView transportationText;
        private TextView stationsText;
        private TextView fareText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.list_ic_history_save_date);
            transportationText = itemView.findViewById(R.id.list_ic_history_save_transportation);
            stationsText = itemView.findViewById(R.id.list_ic_history_save_stations);
            fareText = itemView.findViewById(R.id.list_ic_history_save_fare);
        }
    }
}
