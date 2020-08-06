package com.example.transportationexpenses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IcHistoryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ic_history_list);

        Toolbar toolbar = findViewById(R.id.ic_history_list_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.ic_history_list_recyclerview);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        IcHistoryListAdapter icHistoryListAdapter = new IcHistoryListAdapter(createData());
        recyclerView.setAdapter(icHistoryListAdapter);

        Button saveButton = findViewById(R.id.ic_history_list_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IcHistoryListActivity.this, IcHistoryListCheckActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.history_list_toolbar_menu, menu);
        return true;
    }

    private List<IcHistory> createData() {
        List<IcHistory> icHistories = new ArrayList<>();
        return icHistories;
    }
}