package com.example.user.eefish;

import android.app.MediaRouteButton;
import android.content.Intent;
import android.sax.StartElementListener;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.user.eefish.Controller.AppConfig;
import com.example.user.eefish.Controller.AppController;
import com.example.user.eefish.Model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ViewPager mainTabPager ;
    CardView laut, tawar, udang;
    Bundle kategoriBundle;
    TabLayout mainTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTablayout = (TabLayout) findViewById(R.id.tablayout);
        final ViewPager mainTabPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter pagerAdapterTab = new PagerAdapter( getSupportFragmentManager(), mainTablayout.getTabCount());

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

        super.onCreate(savedInstanceState);
        laut = (CardView) findViewById(R.id.cv_air_laut);
        tawar = (CardView) findViewById(R.id.cv_air_tawar);
        udang = (CardView) findViewById(R.id.cv_udang);

        laut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kategoriBundle.putInt("id",1);

                Intent intentToKategori = (Intent) new Intent(MainActivity.this, KategoriActivity.class);
                intentToKategori.putExtras(kategoriBundle);
                startActivity(intentToKategori);

            }
        });
        tawar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kategoriBundle.putInt("id", 2);

                Intent intentToKategori = (Intent) new Intent(MainActivity.this, KategoriActivity.class);
                intentToKategori.putExtras(kategoriBundle);
                startActivity(intentToKategori);
            }
        });
        udang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kategoriBundle.putInt("id", 3);

                Intent intentToKategori = (Intent) new Intent(MainActivity.this, KategoriActivity.class);
                intentToKategori.putExtras(kategoriBundle);
                startActivity(intentToKategori);
            }
        });

    }


}
