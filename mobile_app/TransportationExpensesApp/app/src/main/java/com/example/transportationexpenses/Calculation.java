package com.example.transportationexpenses;

import java.util.ArrayList;

import static java.lang.Math.abs;

// 過去のデータと読み取ったデータを合わせた後のlistをいれること
public class Calculation {
    public static void setFare (ArrayList<IcHistory> list) {
        for(int i = 0;i < list.size();i++) {
            int fare;
            int prefare = Integer.parseInt(list.get(i + 1).getBalance());
            int nowfare = Integer.parseInt(list.get(i).getBalance());
            fare = abs(prefare - nowfare);
            list.get(i).setFare(String.valueOf(fare));
        }
    }
}