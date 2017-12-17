package com.example.user.eefish.Fragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
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
    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_history_fragment,container,false);
        final Calendar calendar = Calendar.getInstance();
        session = new SessionManager(getActivity());
        listHistoryOnProgress = new ArrayList<HashMap<String,String>>();
        context = getActivity().getApplicationContext();

        rvHistory = rootView.findViewById(R.id.rv_tab_history_fragment);
        LinearLayoutManager llmHistoryOnProgress = new LinearLayoutManager(rootView.getContext());

        //ambil recycler view dari layout
        rvHistory = (RecyclerView) rootView.findViewById(R.id.rv_tab_history_fragment);

        //setting linear layout manager
        LinearLayoutManager llmHistory = new LinearLayoutManager(context);
        llmHistory.setOrientation(LinearLayoutManager.VERTICAL);
        rvHistory.setLayoutManager(llmHistory);

        getHistoryOrderOnProgress(session.getIdUser());

        return rootView;
    }
    public void getHistoryOrderOnProgress(int idUser) {
        URL_ORDER_HISTORY_ON_PROGRESS = ""+ AppConfig.URL_ORDER_ON_GOING + String.valueOf(idUser).toString()+"/on-going";

        final StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                URL_ORDER_HISTORY_ON_PROGRESS,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            //convert response to json object
                            JSONObject obj = new JSONObject(response);

                            //302 = no error on response data
                            if (obj.getInt("code") == 302) {
//                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                                //getting the fish from the response
                                JSONArray jsonArrayOrderItem = obj.getJSONArray("data");
                                for (int a = 0; a < jsonArrayOrderItem.length();a++){
                                    JSONObject objOrderItem = jsonArrayOrderItem.getJSONObject(a);

                                    History Order = new History(
                                            objOrderItem.getInt("order_id"),
                                            objOrderItem.getInt("userid"),
                                            objOrderItem.getString("order_kind"),
                                            objOrderItem.getString("order_date"),
                                            objOrderItem.getString("order_total"),
                                            objOrderItem.getString("order_shipping_cost"),
                                            objOrderItem.getString("order_status")

                                    );
                                    HashMap<String,String> mapOrder = new HashMap<String,String>();
                                    mapOrder.put("order_id",String.valueOf(Order.getOrderID()));
                                    mapOrder.put("userid",String.valueOf(Order.getIdUser()));
                                    mapOrder.put("order_kind",Order.getOrderKind());
                                    mapOrder.put("order_kind",Order.getOrderDate());
                                    mapOrder.put("order_kind",Order.getOrderTotal());
                                    mapOrder.put("order_kind",Order.getOrderShippingCost());
                                    mapOrder.put("order_kind",Order.getOrderStatus());
//
//                                    listDataIkanFiltered.add(mapIkan);
//                                    // ADAPTERVIEW KE LISTVIEW HINGGA SET ADAPTER
//                                    ListAdapterIkan listAdapterIkanIkan = new ListAdapterIkan(KategoriActivity.this,listDataIkanFiltered );
//                                    lvIkan.setAdapter(listAdapterIkanIkan);
                                }
                            }
                            else {
                                Toast.makeText(getContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }

                        }catch (JSONException ex){
                            ex.printStackTrace();
                        }

                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            //TODO NAMPILKAN HASMAP DARI VARIABBLE NULL DARI GET DATA WEB
        };
        AppController.getInstance(getActivity().getApplicationContext()).addToRequestQueue(stringRequest);
    }
}
