package com.example.transportationexpenses;

import java.util.ArrayList;

public class Marge {
    // arr_nからarr_oとダブるところを殺すもの。
    // arr_nのarr_oとダブってない奴だけ居れたArrayListを突き返す。
    // ダブりの定義:片っぽの1つの連番に対し、もう片っぽの連番を総当たりで突き合わせて、
    // 等号:ダブり,等号無しのまま、最後まで回ればダブり無し。
    public static void double_remove(ArrayList<IcHistory> arr_o){
        for(int i=0;i < arr_o.size();i++){
            for(int j=0;j < NFC_Data.NFC_Data.size();j++) {
                if (arr_o.get(i).getseqNo() == NFC_Data.NFC_Data.get(j).getseqNo()) {
                    NFC_Data.NFC_Data.remove(j);
                }else if(j == NFC_Data.NFC_Data.size() - 1){
                    break;
                }
            }
        }
    }
}
