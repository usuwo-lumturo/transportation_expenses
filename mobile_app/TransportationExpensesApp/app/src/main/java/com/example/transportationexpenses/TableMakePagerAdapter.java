package com.example.transportationexpenses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TableMakePagerAdapter extends FragmentPagerAdapter {

    private CharSequence[] tabTitles = {"4月", "5月", "6月"};

    public TableMakePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TableMakeFragment1();
            case 1:
                return new TableMakeFragment2();
            case 2:
                return new TableMakeFragment3();
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
