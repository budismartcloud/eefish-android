package com.example.user.eefish.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.eefish.Fragment.HistoryOnProgressFragment;
import com.example.user.eefish.Fragment.TabDetailIkanPerKILOFragment;
import com.example.user.eefish.Fragment.TabDetailikanPerEKORFragment;

/**
 * Created by Nadia on 16/12/2017.
 */

public class HistoryPagerAdapter extends FragmentStatePagerAdapter {
    int mNumbOfTab;


    public HistoryPagerAdapter(FragmentManager fm, int mNumbOfTab) {
        super(fm);
        this.mNumbOfTab = mNumbOfTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 :
                return new HistoryOnProgressFragment();
            case 1 :
                return new HistoryOnProgressFragment();
            default:
                return new HistoryOnProgressFragment();
        }
    }

    @Override
    public int getCount() {
        return mNumbOfTab;
    }
}
