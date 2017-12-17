package com.example.user.eefish.Fragment;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.user.eefish.Controller.AppConfig;
import com.example.user.eefish.Controller.AppController;
import com.example.user.eefish.Controller.SessionManager;
import com.example.user.eefish.Model.History;
import com.example.user.eefish.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Nadian on 12/16/2017.
 */

public class HistoryOnProgressFragment extends Fragment {

    static String URL_ORDER_HISTORY_ON_PROGRESS ;
    RecyclerView rvHistory;
    SessionManager session;
    private ArrayList<HashMap<String, String>> listHistoryOnProgress;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_history_fragment,container,false);
        final Calendar calendar = Calendar.getInstance();
        session = new SessionManager(getActivity());
        listHistoryOnProgress = new ArrayList<HashMap<String,String>>();

        rvHistory = rootView.findViewById(R.id.rv_tab_history_fragment);
        LinearLayoutManager llmHistoryOnProgress = new LinearLayoutManager(rootView.getContext());


        getHistoryOrderOnProgress(session.getIdUser());
        return rootView;
    }
//    public void getHistoryOrderOnProgress(int idUser) {
//        URL_ORDER_HISTORY_ON_PROGRESS = ""+ AppConfig.URL_ORDER_ON_GOING + String.valueOf(idUser).toString();
//
//        final StringRequest stringRequest = new StringRequest(
//                Request.Method.GET,
//                URL_ORDER_HISTORY_ON_PROGRESS,
//                new Response.Listener<String>(){
//                    @Override
//                    public void onResponse(String response) {
//                        try{
//                            //convert response to json object
//                            JSONObject obj = new JSONObject(response);
//
//                            //302 = no error on response data
//                            if (obj.getInt("code") == 302) {
////                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
//                                //getting the fish from the response
//                                JSONArray jsonArrayFish = obj.getJSONArray("data");
//                                for (int a = 0; a < jsonArrayFish.length();a++){
//                                    JSONObject objFish = jsonArrayFish.getJSONObject(a);

//                                    History fish = new Fish(
//                                            objFish.getInt("fish_id"),
//                                            objFish.getString("weight"),
//                                            objFish.getInt("variety_id"),
//                                            objFish.getString("quantity"),
//                                            objFish.getString("category_id"),
//                                            objFish.getString("fish_name"),
//                                            objFish.getString("variety_name"),
//                                            objFish.getString("singular_price"),
//                                            objFish.getString("collective_price"),
//                                            objFish.getString("category_name"),
//                                            objFish.getString("picture")
//                                    );
//                                    HashMap<String,String> mapIkan = new HashMap<String,String>();
//                                    mapIkan.put("id",String.valueOf(fish.getFish_id()));
//                                    mapIkan.put("fish_name",fish.getFish_name());
//                                    mapIkan.put("colective_price",fish.getColective_price());
//                                    mapIkan.put("singular_price",fish.getSingular_price());
//                                    mapIkan.put("picture",fish.getPicture_fish());
////
//                                    listDataIkanFiltered.add(mapIkan);
//                                    // ADAPTERVIEW KE LISTVIEW HINGGA SET ADAPTER
//                                    ListAdapterIkan listAdapterIkanIkan = new ListAdapterIkan(KategoriActivity.this,listDataIkanFiltered );
//                                    lvIkan.setAdapter(listAdapterIkanIkan);
//                                }
//                            }
//                            else {
//                                Toast.makeText(KategoriActivity.this, "message", Toast.LENGTH_SHORT).show();
//                            }
//
//                        }catch (JSONException ex){
//                            ex.printStackTrace();
//                        }
//
//                    }
//                },new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }){
//            //TODO NAMPILKAN HASMAP DARI VARIABBLE NULL DARI GET DATA WEB
//        };
//        AppController.getInstance(this).addToRequestQueue(stringRequest);
//    }
//}
