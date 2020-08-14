package com.example.transportationexpenses;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IcHistoryFragment3 extends Fragment {

    public IcHistoryFragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ic_history_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.ic_history_list_3_recyclerview);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        IcHistoryListAdapter icHistoryListAdapter = new IcHistoryListAdapter(createData());
        recyclerView.setAdapter(icHistoryListAdapter);
    }

    private List<IcHistory> createData() {
        List<IcHistory> icHistories = new ArrayList<>();
        for (int i = 3000; i < 4000; i++) {
            String date = "XXXX/XX/XX";
            String transportation = "電車";
            String gettingOnStation = "YYY駅";
            String gettingOffStation = "ZZZ駅";
            String departureLine = "(XXX線)";
            String arriveLine = "(XXX線)";
            String fare = "¥" + i / 10;
            String balance = "";
            boolean isHistoryVisible = true;
            IcHistory icHistory = new IcHistory(
                    date, transportation, gettingOnStation, gettingOffStation,
                    departureLine, arriveLine, fare, balance, isHistoryVisible);
            icHistories.add(icHistory);
        }
        return icHistories;
    }
}