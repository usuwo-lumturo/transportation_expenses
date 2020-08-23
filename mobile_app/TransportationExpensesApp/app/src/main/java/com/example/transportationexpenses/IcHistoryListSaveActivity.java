package com.example.transportationexpenses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IcHistoryListSaveActivity extends AppCompatActivity {

    public ArrayList Selected = new ArrayList<IcHistory>();

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ic_history_list_save);

        Select();

        Toolbar toolbar = findViewById(R.id.ic_history_list_save_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.ic_history_list_save_recyclerview);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        IcHistoryListSaveAdapter icHistoryListSaveAdapter = new IcHistoryListSaveAdapter(createData());
        recyclerView.setAdapter(icHistoryListSaveAdapter);

        Button saveButton = findViewById(R.id.ic_history_list_save_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Save_DB(Convert.ExportIcHistory2JSONArray(Selected));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(IcHistoryListSaveActivity.this, MainActivity.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), R.string.ic_history_list_save_savetoast, Toast.LENGTH_LONG);
                toast.show();
            }
        });
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
        icHistories = Selected;
        return icHistories;
    }

    public void Save_DB(JSONArray db_json) throws FileNotFoundException {
        FileOutputStream outputStream = openFileOutput("DB.json", Context.MODE_PRIVATE);
        try {
            outputStream.write(db_json.toString().getBytes());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Select(){
        for(int i = 0;i <= 8;i++){
            if(i != 1){
                Selected.add(NFC_Data.NFC_Data.get(i));
            }
        }
    }

}