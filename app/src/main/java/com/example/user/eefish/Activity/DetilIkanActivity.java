package com.example.user.eefish.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.example.user.eefish.Adapter.DetilIkanPagerAdapter;
import com.example.user.eefish.Controller.AppConfig;
import com.example.user.eefish.Controller.AppController;
import com.example.user.eefish.Controller.SessionManager;
import com.example.user.eefish.Model.Fish;
import com.example.user.eefish.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static com.example.user.eefish.Controller.AppConfig.ADD_TO_CART;
import static com.example.user.eefish.Controller.AppConfig.ROOT_URL;

public class DetilIkanActivity extends AppCompatActivity {
    String URL_GET_FISH_BY_ID, year, iduser, fishItemId,orderkind;
    int idikan;
    ImageView gamberikan;
    TextView namaIkan, singgulaPriceIkan, beratIkan;
    SessionManager session;

    TabLayout mainTablayout;
    ViewPager mainTabPager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ikan);
        idikan = getIntent().getExtras().getInt("id");


        gamberikan = (ImageView)findViewById(R.id.ImageIkanView);
        namaIkan = (TextView) findViewById(R.id.tvNamaIkan);

        GetFishById(idikan);

        mainTablayout = (TabLayout) findViewById(R.id.tablayout_Detail_jenispembelian);
        final ViewPager mainTabPager = (ViewPager) findViewById(R.id.pager_detail_ikan);
        final DetilIkanPagerAdapter menuPagerAdapterTab = new DetilIkanPagerAdapter( getSupportFragmentManager(), mainTablayout.getTabCount());

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



    }
//    //TODO ADD CART
//    private void addcart(){
//        final StringRequest stringRequest = new StringRequest(Request.Method.POST, ADD_TO_CART,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            //converting response to json object
//                            JSONObject obj = new JSONObject(response);
//
//                            //if no error in response
//                            if (obj.getInt("code") == 302) {
//                            //get message
//                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
//
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("user_id", iduser);
//                params.put("order_kind_id",orderkind);
//                params.put("current_year", year);
//                params.put("fish_item_id", fishItemId);
//                return params;
//            }
//        };
//        AppController.getInstance(this).addToRequestQueue(stringRequest);
//    }

    private void GetFishById(int Id) {
        URL_GET_FISH_BY_ID=""+AppConfig.URL_FISH_BY_ID+String.valueOf(Id).toString();
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GET_FISH_BY_ID,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                      try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);

                            //if no error in response
                            if (obj.getInt("code") == 302) {
//                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                JSONArray fishArray = obj.getJSONArray("data");
                                JSONObject objFish = fishArray.getJSONObject(0);

                                Fish fish = new Fish(
                                        objFish.getInt("fish_id"),
                                        objFish.getString("weight"),
                                        objFish.getInt("variety_id"),
                                        objFish.getString("quantity"),
                                        objFish.getString("category_id"),
                                        objFish.getString("fish_name"),
                                        objFish.getString("variety_name"),
                                        objFish.getString("singular_price"),
                                        objFish.getString("collective_price"),
                                        objFish.getString("category_name"),
                                        objFish.getString("picture")

                                );

                                //TODO Set Data ke Android

                                Glide.with(getApplicationContext())
                                        .load(ROOT_URL + fish.getPicture_fish())
                                        .into(gamberikan);
                                namaIkan.setText(fish.getFish_name());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
        };
        AppController.getInstance(this).addToRequestQueue(stringRequest);
    }

}
