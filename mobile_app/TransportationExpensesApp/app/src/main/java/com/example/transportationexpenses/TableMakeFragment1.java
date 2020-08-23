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

public class TableMakeFragment1 extends Fragment {

    public TableMakeFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_table_make_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.table_make_1_recyclerview);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        IcHistoryTableMakeAdapter icHistoryTableMakeAdapter = new IcHistoryTableMakeAdapter(createData());
        recyclerView.setAdapter(icHistoryTableMakeAdapter);
    }

    private List<IcHistory> createData() {
        List<IcHistory> icHistories = new ArrayList<>();
        icHistories = DB_Controler.DB_Save;
        return icHistories;
    }

}