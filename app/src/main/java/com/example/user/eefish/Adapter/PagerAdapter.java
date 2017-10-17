package com.example.user.eefish.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.eefish.Fragment.TabMainHelpFragment;
import com.example.user.eefish.Fragment.TabMainHistoryFragment;
import com.example.user.eefish.Fragment.TabMainHomeFragment;
import com.example.user.eefish.Fragment.TabMainNotifikasiFragment;
import com.example.user.eefish.Fragment.TabMainProfileFragment;


/**
 * Created by Nadian on 9/26/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumbOfTab;


    public PagerAdapter(FragmentManager fm, int mNumbOfTab) {
        super(fm);
        this.mNumbOfTab = mNumbOfTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 :
                return new TabMainHomeFragment();
            case 1 :
                return new TabMainHistoryFragment();
            case 2:
                return new TabMainNotifikasiFragment();
            case 3:
                return new TabMainHelpFragment();
            case 4:
                return new TabMainProfileFragment();
            default:
                return new TabMainHomeFragment();
        }
    }

    @Override
    public int getCount() {
        return mNumbOfTab;
    }
}
