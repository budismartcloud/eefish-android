package com.example.user.eefish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.user.eefish.Controller.AppConfig;
import com.example.user.eefish.Controller.AppController;
import com.example.user.eefish.Model.Fish;
import com.example.user.eefish.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KategoriActivity extends AppCompatActivity {
    static String URL_FISH_BY_KATEGORI_NUM;
    Bundle acceptedBundleKategori;
    int onKategori;
    ArrayList<HashMap<String,String>> listDataIkanFiltered;
    RecyclerView lvIkan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);
        listDataIkanFiltered = new ArrayList<HashMap<String,String>>();

        //acceptedBundleKategori = getIntent().getExtras();
        onKategori = getIntent().getExtras().getInt("id");

        //melakukan method untuk mengambil ikan terfilter
        getFilteredFishes(onKategori);

    }

    public void getFilteredFishes(int idKategori){
        URL_FISH_BY_KATEGORI_NUM =""+AppConfig.URL_FISH_BY_KATEGORI+String.valueOf(idKategori).toString();

        final StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                URL_FISH_BY_KATEGORI_NUM,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            //convert response to json object
                            JSONObject obj = new JSONObject(response);

                            //302 = no error on response data
                            if (obj.getInt("code") == 302) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                                //getting the fish from the response
                              JSONArray jsonArrayFish = obj.getJSONArray("data");
                                for (int a = 0; a < jsonArrayFish.length();a++){
                                    JSONObject objFish = jsonArrayFish.getJSONObject(a);

                                    Fish fish = new Fish(
                                            objFish.getInt("id"),
                                            objFish.getInt("weight"),
                                            objFish.getInt("variety_id"),
                                            objFish.getInt("quantity"),
                                            objFish.getInt("category_id"),
                                            objFish.getString("fish_name"),
                                            objFish.getString("variety_name"),
                                            objFish.getString("singular_price"),
                                            objFish.getString("colective_price"),
                                            objFish.getString("category_name")

                                    );
                                    HashMap<String,String> mapIkan = new HashMap<String,String>();
                                    mapIkan.put("id",String.valueOf(fish.getId_fish()));
                                    mapIkan.put("fish_name",fish.getFish_name());
                                    mapIkan.put("colective_price",fish.getColective_price());
                                    mapIkan.put("singular_price",fish.getSingular_price());
                                    listDataIkanFiltered.add(mapIkan);
                                    // ADAPTERVIEW KE LISTVIEW HINGGA SET ADAPTER
                                    ListAdapter listAdapterIkan = new ListAdapter(KategoriActivity.this,listDataIkanFiltered );
                                    lvIkan.setAdapter(listAdapterIkan);

                                }
                            }
                            else {
                                Toast.makeText(KategoriActivity.this, "message", Toast.LENGTH_SHORT).show();
                            }

                            }catch (JSONException ex){
                            ex.printStackTrace();
                        }

                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            //TODO NAMPILKAN HASMAP DARI VARIABBLE NULL DARI GET DATA WEB
        };
        AppController.getInstance(this).addToRequestQueue(stringRequest);
    }
}

