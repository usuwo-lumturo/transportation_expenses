package com.example.transportationexpenses;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.NfcF;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.example.transportationexpenses.NFC_GET.toHex;

public class IcReadHistoryListActivity extends AppCompatActivity {

    private static final String TAG = "NFCSample";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            // カードID取得。Activityはカード認識時起動に設定しているのでここで取れる。
            byte[] felicaIDm = new byte[]{0};
            Intent intent = getIntent();
            Tag tag = (Tag) intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            if (tag != null) {
                felicaIDm = tag.getId();
            }

            // NFCモードをFモードとしてtagを渡す。
            NfcF nfc = NfcF.get(tag);

            nfc.connect();
            byte[] req = NFC_GET.readWithoutEncryption(felicaIDm, 10);
            Log.d(TAG, "req:" + toHex(req));
            // カードにリクエスト送信
            byte[] res = nfc.transceive(req);
            Log.d(TAG, "res:"+toHex(res));
            nfc.close();
            // 結果を文字列に変換して表示
            NFC_Data.NFC_Data = NFC_GET.parse(res);
            /*
            Intent next_intent = new Intent(IcReadActivity.this, IcReadHistoryListActivity.class);
            startActivity(next_intent);
            */
        } catch (Exception e) {
            Log.e(TAG, e.getMessage() , e);
        }


        setContentView(R.layout.activity_ic_read_history_list);

        Toolbar toolbar = findViewById(R.id.ic_read_history_list_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final RecyclerView recyclerView = findViewById(R.id.ic_read_history_list_recyclerview);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Collections.reverse(NFC_Data.NFC_Data);
        Calculation.setFare(NFC_Data.NFC_Data);
        Marge.double_remove(DB_Controler.DB_Save);

        NFC_Data.del_other();


        IcReadHistoryListAdapter icReadHistoryListAdapter = new IcReadHistoryListAdapter(createData(NFC_Data.NFC_Data));
        recyclerView.setAdapter(icReadHistoryListAdapter);

        Button saveButton = findViewById(R.id.ic_read_history_list_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(IcReadHistoryListActivity.this, IcHistoryListSaveActivity.class);
            startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.ic_baseline_error_outline_24)
                    .setTitle(R.string.ic_read_history_list_alert_dialog_title)
                    .setMessage(R.string.ic_read_history_list_alert_dialog_message)
                    .setPositiveButton(R.string.ic_read_history_list_alert_dialog_ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton(R.string.ic_read_history_list_alert_dialog_cancel, null)
                    .show();
        }
        return true;
    }

    private List<IcHistory> createData(ArrayList<IcHistory> NFC_icHistories) {
        List<IcHistory> icHistories = new ArrayList<>();
        icHistories = NFC_icHistories;
        if(icHistories.get(icHistories.size()-1).getTransportation() != "乗車") icHistories.remove(icHistories.size()-1);
        return icHistories;
    }
}