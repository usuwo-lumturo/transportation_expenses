package com.example.transportationexpenses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IcHistoryListCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ic_history_list_check);

        Toolbar toolbar = findViewById(R.id.ic_history_list_check_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.ic_history_list_check_recyclerview);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        IcHistoryListCheckAdapter icHistoryListCheckAdapter = new IcHistoryListCheckAdapter(createData());
        recyclerView.setAdapter(icHistoryListCheckAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

    private List<IcHistory> createData() {
        List<IcHistory> icHistories = new ArrayList<>();
       
        return icHistories;
    }
}