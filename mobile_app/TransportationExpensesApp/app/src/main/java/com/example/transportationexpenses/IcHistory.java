package com.example.transportationexpenses;

public class IcHistory {

    /** 日付 */
    private String date;
    /** 交通手段 */
    private String transportation;
    /** 乗降車駅 */
    private String boardingStation;
    /** 運賃 */
    private String fare;

    public IcHistory(String date, String transportation, String boardingStation, String fare) {
        this.date = date;
        this.transportation = transportation;
        this.boardingStation = boardingStation;
        this.fare = fare;
    }

    public String getDate() {
        return date;
    }

    public String getTransportation() {
        return transportation;
    }

    public String getBoardingStation() {
        return boardingStation;
    }

    public String getFare() {
        return fare;
    }
}
