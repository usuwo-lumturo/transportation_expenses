package com.example.transportationexpenses;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class IcHistoryTableMakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ic_history_table_make);

        Toolbar toolbar = findViewById(R.id.ic_history_table_make_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TableMakePagerAdapter adapter = new TableMakePagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.ic_history_table_make_view_pager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);

        Button button = findViewById(R.id.ic_history_table_make_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildAlertDialog();
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

    private void buildAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("勤務表作成確認")
                .setMessage("の勤務表を作成します。よろしいですか？")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(IcHistoryTableMakeActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast toast = Toast.makeText(getApplicationContext(), "勤務表の作成が完了しました。", Toast.LENGTH_LONG);
                        toast.show();
                    }
                })
                .setNegativeButton("キャンセル", null)
                .show();
    }

}