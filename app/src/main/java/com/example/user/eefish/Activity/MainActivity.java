package com.example.user.eefish.Activity;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.user.eefish.Adapter.MenuPagerAdapter;
import com.example.user.eefish.Controller.SessionManager;
import com.example.user.eefish.R;

public class MainActivity extends AppCompatActivity {
    TabLayout mainTablayout;
    CardView laut, tawar, udang;
    SessionManager session;
    ImageView butToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());

        mainTablayout = (TabLayout) findViewById(R.id.tablayout);

        final ViewPager mainTabPager = (ViewPager) findViewById(R.id.pager);
        final MenuPagerAdapter menuPagerAdapterTab = new MenuPagerAdapter( getSupportFragmentManager(), mainTablayout.getTabCount());

        laut = (CardView) findViewById(R.id.cv_air_laut);
        tawar = (CardView) findViewById(R.id.cv_air_tawar);
        udang = (CardView) findViewById(R.id.cv_udang);
        butToCart = (ImageView) findViewById(R.id.but_Cart);


        mainTabPager.setAdapter(menuPagerAdapterTab);
        mainTabPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTablayout));

        mainTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainTabPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //TODO KOSONG
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //TODO KOSONG
            }
        });

        butToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CartActivity.class);
                startActivity(intent);
            }
        });
    }
}
