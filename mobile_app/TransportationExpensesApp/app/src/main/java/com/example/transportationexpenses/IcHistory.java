package com.example.transportationexpenses;

public class IcHistory {

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

    public IcHistory(String date, String transportation,
                     String gettingOnStation, String gettingOffStation,
                     String departureLine, String arriveLine, String fare,
                     String balance, boolean isHistoryVisible) {
        this.date = date;
        this.transportation = transportation;
        this.gettingOnStation = gettingOnStation;
        this.gettingOffStation = gettingOffStation;
        this.departureLine = departureLine;
        this.arriveLine = arriveLine;
        this.fare = fare;
        this.balance = balance;
        this.isHistoryVisible = isHistoryVisible;
    }

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
}