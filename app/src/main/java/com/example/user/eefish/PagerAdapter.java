package com.example.user.eefish;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


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
                return new Tab1_Home_Fragment();
            case 1 :
                return new Tab1_Home_Fragment();
            case 2:
                return new Tab1_Home_Fragment();
            case 3:
                return new Tab1_Home_Fragment();
            case 4:
                return new Tab1_Home_Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumbOfTab;
    }
}
