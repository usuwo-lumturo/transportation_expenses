package com.example.transportationexpenses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class IcHistoryPagerAdapter extends FragmentPagerAdapter {


    private CharSequence[] tabTitles = {"2月", "3月", "4月"};

    public IcHistoryPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new IcHistoryFragment1();
            case 1:
                return new IcHistoryFragment2();
            case 2:
                return new IcHistoryFragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
