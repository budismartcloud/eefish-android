package com.example.user.eefish.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.user.eefish.Activity.CartActivity;
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

import static com.example.user.eefish.Controller.AppConfig.*;

public class TabDetailIkanPerKILOFragment extends Fragment {
    String URL_GET_FISH_BY_ID;
    int idikan;
    TextView hargaikan;
    Button addcartButton;
    Intent afterlogin;
    SessionManager sessionManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_perkilo, container, false);
        final Calendar calendar = Calendar.getInstance();
        sessionManager = new SessionManager(getContext());

        idikan = getActivity().getIntent().getExtras().getInt("id");
        hargaikan = (TextView) rootView.findViewById(R.id.tvHargaIkanTerpilih);
        addcartButton = (Button) rootView.findViewById(R.id.but_detail_addcart);
        GetFishById(idikan);

        addcartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String iduser = String.valueOf(sessionManager.getIdUser());
                String year = String.valueOf(calendar.get(Calendar.YEAR));
                String orderkind = "1";
                String fishItemId = String.valueOf(idikan);
                addcart(iduser,year,orderkind,fishItemId);
            }
        });

        return rootView;
    }

    private void addcart(final String iduser, final String year, final String fishItemId, final String orderkind) {
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.ADD_TO_CART,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//
                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);
                            //if no error in response
                            if (obj.getInt("code") == 302) {
                                Toast.makeText(getContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getContext(),CartActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity().getApplicationContext(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user_id", iduser);
                params.put("order_kind_id", orderkind);
                params.put("current_year", year);
                params.put("fish_item_id", fishItemId);
                return params;
            }
        };
        AppController.getInstance(getContext()).addToRequestQueue(stringRequest);
    }

    private void GetFishById(int Id) {
        URL_GET_FISH_BY_ID=""+ AppConfig.URL_FISH_BY_ID+String.valueOf(Id);
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GET_FISH_BY_ID,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);

                            //if no error in response
                            if (obj.getInt("code") == 302) {
//                                Toast.makeText(getActivity(), obj.getString("message"), Toast.LENGTH_SHORT).show();

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

                                hargaikan.setText("Rp."+fish.getColective_price()+",00");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
        };
        AppController.getInstance(getActivity().getApplicationContext()).addToRequestQueue(stringRequest);
    }


}
