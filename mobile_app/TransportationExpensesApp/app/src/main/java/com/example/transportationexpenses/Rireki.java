package com.example.transportationexpenses;

import android.util.SparseArray;

import org.json.JSONArray;
import org.json.JSONException;

public class Rireki {

    public int termId;      //端末種
    public int procId;      //処理
    public int year;        //年
    public int month;       //月
    public int day;         //日
    public String inLine;   //入線区
    public String inStation;   //入駅順
    public String outLine; //出線区
    public String outStation; //出駅順
    public String kind;     //電車・バス・物販
    public int remain;      //残高
    public int seqNo;       //連番
    public int reasion;     //リージョン
    public String stationjson = "StationCode.json";

    public Rireki(){
    }

    public static Rireki parse(byte[] res, int off) throws NoSuchMethodException, JSONException {
        Rireki self = new Rireki();
        self.init(res, off);
        return self;
    }

    private void init(byte[] res, int off) throws NoSuchMethodException, JSONException {
        this.termId = res[off]; //0: 端末種
        this.procId = res[off+1]; //1: 処理
        //2-3: ??
        int mixInt = toInt(res, off, 4,5);
        this.year  = (mixInt >> 9) & 0x07f;
        this.month = (mixInt >> 5) & 0x00f;
        this.day   = mixInt & 0x01f;

        if (isStation(this.procId)) {
            this.kind = "乗車";
            System.out.println("機械コード:" + String.valueOf(this.procId));
            //　乗降情報
            getLineAndSt(res[off+6],res[off+7],res[off+8],res[off+9]);
            //this.kind = res[off+6] < 0x80 ? "JR" : "公営/私鉄" ;
        } else {
            this.kind = PROC_MAP.get(procId);
            this.inLine=null;
            this.inStation=null;
            this.outLine=null;
            this.outLine=null;
        }
        // 線区、駅順を取得
        //System.out.println(MyApplication.getInstance());
        //ここでMyApplication.getInstance()に値が入らない！！（null）（泣）


        this.remain  = toInt(res, off, 11,10); //10-11: 残高 (little endian)
        this.seqNo   = toInt(res, off, 12,13,14); //12-14: 連番
        this.reasion = res[off+15]; //15: リージョン
    }

    private int toInt(byte[] res, int off, int... idx) {
        int num = 0;
        for (int i = 0;i < idx.length; i++) {
            num = num << 8;
            num += ((int)res[off + idx[i]]) & 0x0ff;
        }
        return num;
    }
    private boolean isStation(int procId) {
        return procId == 1;
    }

    //ここでjsonの中身を作る（最終的なjson形式(string型)はmainのparse）
    //変数として扱いたい(「”連番”」など)場合は+"¥"連番¥""と書く
    public IcHistory toIcHistory(){
        IcHistory hist = new IcHistory(
                seqNo,
                year+":"+month+":"+day,
                kind,
                inStation,
                outStation,
                inLine,
                outLine,
                "0",
                String.valueOf(remain),
                true);
        return hist;
    }


    public static final SparseArray<String> TERM_MAP = new SparseArray<String>();
    public static final SparseArray<String> PROC_MAP = new SparseArray<String>();
    static {
        TERM_MAP.put(3 , "精算機");
        TERM_MAP.put(4 , "携帯型端末");
        TERM_MAP.put(5 , "車載端末");
        TERM_MAP.put(7 , "券売機");
        TERM_MAP.put(8 , "券売機");
        TERM_MAP.put(9 , "入金機");
        TERM_MAP.put(18 , "券売機");
        TERM_MAP.put(20 , "券売機等");
        TERM_MAP.put(21 , "券売機等");
        TERM_MAP.put(22 , "改札機");
        TERM_MAP.put(23 , "簡易改札機");
        TERM_MAP.put(24 , "窓口端末");
        TERM_MAP.put(25 , "窓口端末");
        TERM_MAP.put(26 , "改札端末");
        TERM_MAP.put(27 , "携帯電話");
        TERM_MAP.put(28 , "乗継精算機");
        TERM_MAP.put(29 , "連絡改札機");
        TERM_MAP.put(31 , "簡易入金機");
        TERM_MAP.put(70 , "VIEW ALTTE");
        TERM_MAP.put(72 , "VIEW ALTTE");
        TERM_MAP.put(199 , "物販端末");
        TERM_MAP.put(200 , "自販機");

        PROC_MAP.put(1 , "運賃支払(改札出場)");
        PROC_MAP.put(2 , "チャージ");
        PROC_MAP.put(3 , "券購(磁気券購入)");
        PROC_MAP.put(4 , "精算");
        PROC_MAP.put(5 , "精算 (入場精算)");
        PROC_MAP.put(6 , "窓出 (改札窓口処理)");
        PROC_MAP.put(7 , "新規 (新規発行)");
        PROC_MAP.put(8 , "控除 (窓口控除)");
        PROC_MAP.put(13 , "バス (PiTaPa系)");
        PROC_MAP.put(15 , "バス (IruCa系)");
        PROC_MAP.put(17 , "再発 (再発行処理)");
        PROC_MAP.put(19 , "支払 (新幹線利用)");
        PROC_MAP.put(20 , "入A (入場時オートチャージ)");
        PROC_MAP.put(21 , "出A (出場時オートチャージ)");
        PROC_MAP.put(31 , "入金 (バスチャージ)");
        PROC_MAP.put(35 , "券購 (バス路面電車企画券購入)");
        PROC_MAP.put(70 , "物販");
        PROC_MAP.put(72 , "特典 (特典チャージ)");
        PROC_MAP.put(73 , "入金 (レジ入金)");
        PROC_MAP.put(74 , "物販取消");
        PROC_MAP.put(75 , "入物 (入場物販)");
        PROC_MAP.put(198 , "物現 (現金併用物販)");
        PROC_MAP.put(203 , "入物 (入場現金併用物販)");
        PROC_MAP.put(132 , "精算 (他社精算)");
        PROC_MAP.put(133 , "精算 (他社入場精算)");
    }

    public void getLineAndSt(byte inLine, byte inStation, byte outLine, byte outStation) throws NoSuchMethodException, JSONException {
        System.out.println("呼ばれた");
        int strinLine = Integer.parseInt(String.format("%03d", inLine));
        int strinStation = Integer.parseInt(String.format("%03d", inStation));
        int stroutLine = Integer.parseInt(String.format("%03d", outLine));
        int stroutStation = Integer.parseInt(String.format("%03d", outStation));
        JSONArray sta_json = new JSONArray(StationCode.json_sta);

        String line = "";
        boolean inOK = false;
        boolean outOK = false;
        String[] arr = null;


        for(int i = 0;i < sta_json.length();i++){
            int json_line = Integer.parseInt(sta_json.getJSONObject(i).getString("LineCode"));
            int json_sta = Integer.parseInt(sta_json.getJSONObject(i).getString("StationCode"));
            if (strinLine == json_line && strinStation == json_sta) {
                this.inLine = sta_json.getJSONObject(i).getString("LineName");
                this.inStation = sta_json.getJSONObject(i).getString("StationName");
                System.out.println("inOK");
            } else if (stroutLine == json_line && stroutStation == json_sta) {
                this.outLine = sta_json.getJSONObject(i).getString("LineName");
                this.outStation = sta_json.getJSONObject(i).getString("StationName");
                System.out.println("outOK");
                outOK = true;
            }
        }
        System.out.println("reader OK");
    }

}
