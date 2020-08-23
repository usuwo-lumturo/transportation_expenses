package com.example.transportationexpenses;

import java.util.ArrayList;

public class NFC_Data {
    public static ArrayList<IcHistory> NFC_Data = new ArrayList<IcHistory>();

    public static void del_other(){
        try{
            for(int i = 0; i < NFC_Data.size() - 1;i++){
                if(NFC_Data.get(i).getTransportation() != "乗車") NFC_Data.remove(i);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
