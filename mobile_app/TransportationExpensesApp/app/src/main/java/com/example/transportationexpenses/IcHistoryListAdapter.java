package com.example.transportationexpenses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        holder.dateText.setText(icHistoryList.get(position).getDate());
        holder.transportationText.setText(icHistoryList.get(position).getTransportation());
        holder.departureLineText.setText(icHistoryList.get(position).getDepartureLine());
        holder.getOnStationText.setText(icHistoryList.get(position).getGettingOnStation());
        holder.arriveLineText.setText(icHistoryList.get(position).getArriveLine());
        holder.getOffStationText.setText(icHistoryList.get(position).getGettingOffStation());
        holder.fareText.setText(icHistoryList.get(position).getFare());
    }

    @Override
    public int getItemCount() {
        return icHistoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView dateText;
        private TextView transportationText;
        private TextView departureLineText;
        private TextView getOnStationText;
        private TextView arriveLineText;
        private TextView getOffStationText;
        private TextView fareText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.list_ic_history_date);
            transportationText = itemView.findViewById(R.id.list_ic_history_transportation);
            departureLineText = itemView.findViewById(R.id.list_ic_history_departure_line);
            getOnStationText = itemView.findViewById(R.id.list_ic_history_on_station);
            arriveLineText = itemView.findViewById(R.id.list_ic_history_arrive_line);
            getOffStationText = itemView.findViewById(R.id.list_ic_history_off_station);
            fareText = itemView.findViewById(R.id.list_ic_history_fare);
        }
    }
}
