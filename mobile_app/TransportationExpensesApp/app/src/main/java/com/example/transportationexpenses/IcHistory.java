package com.example.transportationexpenses;

public class IcHistory {

    /** 購買番号 */
    private int seqNo;
    /** 日付 */
    private String date;
    /** 交通手段 */
    private String transportation;
    /** 乗車駅 */
    private String gettingOnStation;
    /** 降車駅 */
    private String gettingOffStation;
    /** 入線区 */
    private String departureLine;
    /** 出線区 */
    private String arriveLine;
    /** 運賃 */
    private String fare;
    /** 残高 */
    private String balance;
    /** 表示フラグ */
    private boolean isHistoryVisible;

    public IcHistory(int seqNo,
                     String date, String transportation,
                     String gettingOnStation, String gettingOffStation,
                     String departureLine, String arriveLine, String fare,
                     String balance, boolean isHistoryVisible) {
        this.seqNo = seqNo;
        this.date = date;
        this.transportation = transportation;
        this.gettingOnStation = gettingOnStation;
        this.gettingOffStation = gettingOffStation;
        if(departureLine != null){
            this.departureLine = departureLine + "線";
        }
        else{
            this.departureLine = null;
        }
        if(arriveLine != null){
            this.arriveLine = arriveLine + "線";
        }
        else {
            this.arriveLine = null;
        }
        this.fare = fare;
        this.balance = balance;
        this.isHistoryVisible = isHistoryVisible;
    }

    public int getseqNo(){ return seqNo; }

    public String getDate() {
        return date;
    }

    public String getTransportation() {
        return transportation;
    }

    public String getGettingOnStation() {
        return gettingOnStation;
    }
    
    public String getGettingOffStation() {
        return gettingOffStation;
    }
    
    public String getDepartureLine() {
        return departureLine;
    }
    
    public String getArriveLine() {
        return arriveLine;
    }

    public String getFare() {
        return fare;
    }

    public String getBalance() {
        return balance;
    }
    
    public boolean isHistoryVisible() {
        return isHistoryVisible;
    }

    public void setFare(String n_fare){ this.fare = n_fare ;}
}