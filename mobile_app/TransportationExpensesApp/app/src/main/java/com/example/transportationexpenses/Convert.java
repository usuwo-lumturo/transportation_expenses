package com.example.transportationexpenses;

import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/*
      public class Convert
        JSONArrayをArrayList<IcHistory>へ変換、
        ArrayList<IcHistory>をJSONArrayへ変換するクラス
*/

public class Convert {

    /*
          ArrayList<IcHistory> ExportJSON2IcHistory(JSONArray json)
          JSONArrayをInHistory型のArrayListへ変換する関数
          INPUT:JSONArray json
          OUTPUT:ArrayList<IcHistory>
    */

    public ArrayList<IcHistory> ExportJSON2IcHistory(JSONArray json) throws JSONException {
        ArrayList<IcHistory> list = new ArrayList();
        for(int i = 0;i < json.length() ; i++){
            list.add(new IcHistory(
                    json.getJSONObject(i).getInt("連番"),
                    json.getJSONObject(i).getString("日付"),
                    json.getJSONObject(i).getString("交通手段"),
                    json.getJSONObject(i).getString("入駅順"),
                    json.getJSONObject(i).getString("出駅順"),
                    json.getJSONObject(i).getString("入線区"),
                    json.getJSONObject(i).getString("出線区"),
                    json.getJSONObject(i).get("運賃").toString(),
                    json.getJSONObject(i).get("残高").toString(),
                    json.getJSONObject(i).getBoolean("表示フラグ")));
        }
        return list;
    }



    /*
          ArrayList<IcHistory> ExportIcHistory2JSONArray(JSONArray json)
          JSONArrayをInHistory型のArrayListへ変換する関数
          INPUT:JSONArray json
          OUTPUT:ArrayList<IcHistory>
     */
    public JSONArray ExportIcHistory2JSONArray(ArrayList<IcHistory> list) throws JSONException {
        JSONArray json_list = new JSONArray();
        for(int i = 0;i < list.size();i++) {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("連番",list.get(i).getseqNo());
            jsonobject.put("交通手段",list.get(i).getTransportation());
            jsonobject.put("日付",list.get(i).getDate());
            jsonobject.put("入線区",list.get(i).getDepartureLine());
            jsonobject.put("入駅順",list.get(i).getGettingOnStation());
            jsonobject.put("出線区",list.get(i).getArriveLine());
            jsonobject.put("出駅順",list.get(i).getGettingOffStation());
            jsonobject.put("運賃",Integer.parseInt(list.get(i).getFare()));
            jsonobject.put("残高",list.get(i).getBalance());
            jsonobject.put("表示フラグ",list.get(i).isHistoryVisible());
            json_list.put(jsonobject);
        }
        return json_list;
    }



}
