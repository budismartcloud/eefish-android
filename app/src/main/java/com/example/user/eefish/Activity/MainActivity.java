package com.example.user.eefish.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import com.example.user.eefish.Adapter.PagerAdapter;
import com.example.user.eefish.Controller.SessionManager;
import com.example.user.eefish.R;

public class MainActivity extends AppCompatActivity {
    TabLayout mainTablayout;
    ViewPager mainTabPager ;
    CardView laut, tawar, udang;
    Bundle kategoriBundle;
    SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());

        mainTablayout = (TabLayout) findViewById(R.id.tablayout);
        final ViewPager mainTabPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter pagerAdapterTab = new PagerAdapter( getSupportFragmentManager(), mainTablayout.getTabCount());

        laut = (CardView) findViewById(R.id.cv_air_laut);
        tawar = (CardView) findViewById(R.id.cv_air_tawar);
        udang = (CardView) findViewById(R.id.cv_udang);


        mainTabPager.setAdapter(pagerAdapterTab);
        mainTabPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTablayout));

        mainTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


//        laut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                kategoriBundle.putInt("id",1);
//
//                Intent intentToKategori = (Intent) new Intent(MainActivity.this, KategoriActivity.class);
//                intentToKategori.putExtras(kategoriBundle);
//                startActivity(intentToKategori);
//
//            }
//        });
//        tawar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                kategoriBundle.putInt("id", 2);
//                Intent intentToKategori = (Intent) new Intent(MainActivity.this, KategoriActivity.class);
//                intentToKategori.putExtras(kategoriBundle);
//                startActivity(intentToKategori);
//            }
//        });
//        udang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                kategoriBundle.putInt("id", 3);
//
//                Intent intentToKategori = (Intent) new Intent(MainActivity.this, KategoriActivity.class);
//                intentToKategori.putExtras(kategoriBundle);
//                startActivity(intentToKategori);
//            }
//        });

    }
}
