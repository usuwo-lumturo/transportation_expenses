package com.example.transportationexpenses;

import java.util.ArrayList;

public class Marge {
    // arr_nからarr_oとダブるところを殺すもの。
    // arr_nのarr_oとダブってない奴だけ居れたArrayListを突き返す。
    // ダブりの定義:片っぽの1つの連番に対し、もう片っぽの連番を総当たりで突き合わせて、
    // 等号:ダブり,等号無しのまま、最後まで回ればダブり無し。
    public static ArrayList<IcHistory> double_remove(ArrayList<IcHistory> arr_o,ArrayList<IcHistory> arr_n){
        ArrayList r_arr = new ArrayList<IcHistory>();
        for(int i=0;i < arr_o.size();i++){
            for(int j=0;j < arr_n.size();j++) {
                if (arr_o.get(i).getseqNo() == arr_n.get(j).getseqNo()) {
                    break;
                }else if(j == arr_n.size() - 1){
                    r_arr.add(arr_n.get(j));
                }
            }
        }
        return r_arr;
    }
}
