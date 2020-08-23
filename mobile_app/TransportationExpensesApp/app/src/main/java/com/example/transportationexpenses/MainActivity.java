package com.example.transportationexpenses;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StationCode.json_sta = get_json("StationCode.json");
        DB_Controler.DB_Save = Convert.ExportJSON2IcHistory(get_db("DB.json"));
        del_db("DB.json");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        Button icButton = findViewById(R.id.main_button_ic_read);
        icButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IcReadActivity.class);
                startActivity(intent);
            }
        });

        Button tableMakeButton = findViewById(R.id.main_button_table_make);
        tableMakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IcHistoryTableMakeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.main_toolbar_menu_history) {
            Intent intent = new Intent(MainActivity.this, IcHistoryListActivity.class);
            startActivity(intent);
        }
        return true;
    }

    public JSONArray get_db(String strfilename) {
        try {
            FileInputStream fileInputStream = openFileInput(strfilename);
            String text = null;

            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
            String lineBuffer;
            while ((lineBuffer = reader.readLine()) != null) {
                text = lineBuffer;
            }
            JSONArray array = new JSONArray(text);
            return array;
        }catch (Exception e){
            JSONArray array = new JSONArray();
            return  array;
        }
    }

    // 真っ先にStationCodeのDBを読み出し。
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String get_json(String strfilename){

        //　FilereaderとBufferedRenderを準備
        FileReader fr = null;
        BufferedReader br = null;

        // アセットファイル読み込み
        AssetManager json_ast = getResources().getAssets();
        InputStream is;

        try{
            // json objを開いて、BufferReaderへ
            is = json_ast.open(strfilename);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bf = new BufferedReader(isr);

            // BufferReaderから読み出す為、StringBuilderメソッドを作成
            StringBuilder return_str = new StringBuilder();

            // StringBuilderへ代入すべく1行目を読んだらWhileLoopを使って2行目以降を読む
            String str = bf.readLine();
            while(str != null){
                return_str.append(str + System.getProperty("line.separator"));
                str = bf.readLine();
            }

            // 返す
            return return_str.toString();

        } catch (FileNotFoundException e) {
            System.out.println(e);
            return null;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //ToDO:テスト実装じゃけん、必ず消すこと。
    public void del_db(String strfilename) {
        try {
            FileOutputStream fileOutputStream = openFileOutput(strfilename,  Context.MODE_PRIVATE);
            fileOutputStream.write("[\"\"]".getBytes());
        }catch (Exception e){

        }
    }
}