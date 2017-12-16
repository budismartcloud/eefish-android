package com.example.user.eefish.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.eefish.Fragment.TabDetailIkanPerKILOFragment;
import com.example.user.eefish.Fragment.TabDetailikanPerEKORFragment;

/**
 * Created by Rafif on 20/11/2017.
 */

public class DetilIkanPagerAdapter extends FragmentStatePagerAdapter {
    int mNumbOfTab;


    public DetilIkanPagerAdapter(FragmentManager fm, int mNumbOfTab) {
        super(fm);
        this.mNumbOfTab = mNumbOfTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 :
                return new TabDetailIkanPerKILOFragment();
            case 1 :
                return new TabDetailikanPerEKORFragment();
            default:
                return new TabDetailIkanPerKILOFragment();
        }
    }

    @Override
    public int getCount() {
        return mNumbOfTab;
    }
}
