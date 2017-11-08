package com.example.user.eefish.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.user.eefish.Adapter.ListAdapterIkan;
import com.example.user.eefish.Controller.AppConfig;
import com.example.user.eefish.Controller.AppController;
import com.example.user.eefish.Model.Fish;
import com.example.user.eefish.Model.User;
import com.example.user.eefish.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DetilIkanActivity extends AppCompatActivity {
    String URL_GET_FISH_BY_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);


    }

    private void GetFishById(int Id) {
        URL_GET_FISH_BY_ID=""+AppConfig.URL_LOGIN+String.valueOf(Id).toString();
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_GET_FISH_BY_ID,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                      try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);

                            //if no error in response
                            if (obj.getInt("code") == 302) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                JSONObject objFish = obj.getJSONObject("data");

                                Fish fish = new Fish(
                                        objFish.getInt("fish_id"),
                                        objFish.getInt("weight"),
                                        objFish.getInt("variety_id"),
                                        objFish.getInt("quantity"),
                                        objFish.getInt("category_id"),
                                        objFish.getString("fish_name"),
                                        objFish.getString("variety_name"),
                                        objFish.getString("singular_price"),
                                        objFish.getString("collective_price"),
                                        objFish.getString("category_name")

                                );

                                //TODO pindah Intent} else {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
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
