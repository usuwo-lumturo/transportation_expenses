package com.example.transportationexpenses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IcReadHistoryListAdapter extends RecyclerView.Adapter<IcReadHistoryListAdapter.ViewHolder> {

    private List<IcHistory> icHistoryList;

    public IcReadHistoryListAdapter(List<IcHistory> icHistories){
        this.icHistoryList = icHistories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_ic_read_history, parent, false);
        return new IcReadHistoryListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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
            dateText = itemView.findViewById(R.id.list_ic_read_history_date);
            transportationText = itemView.findViewById(R.id.list_ic_read_history_transportation);
            stationsText = itemView.findViewById(R.id.list_ic_read_history_stations);
            fareText = itemView.findViewById(R.id.list_ic_read_history_fare);
        }
    }
}
