package com.example.user.eefish.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.user.eefish.Adapter.CartAdapter;
import com.example.user.eefish.Controller.AppConfig;
import com.example.user.eefish.Controller.AppController;
import com.example.user.eefish.Controller.SessionManager;
import com.example.user.eefish.Model.OrderItem;
import com.example.user.eefish.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class CartActivity extends AppCompatActivity {

    static String URL_CART;
    ArrayList<HashMap<String,String>> listCartData;
    RecyclerView lvCart;
    SessionManager user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_eefish);

        listCartData = new ArrayList<HashMap<String,String>>();
        user = new SessionManager(getApplicationContext());

        lvCart = (RecyclerView) findViewById(R.id.lv_incart);
        LinearLayoutManager llmCart = new LinearLayoutManager(this);
        llmCart.setOrientation(LinearLayoutManager.VERTICAL);
        lvCart.setLayoutManager(llmCart);

        getCartUser(user.getIdUser());
    }

    public void getCartUser(int iduser){
        URL_CART =""+AppConfig.URL_LIST_CART+String.valueOf(iduser)+"/list";
        Toast.makeText(this, URL_CART, Toast.LENGTH_LONG).show();

        final StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                URL_CART,
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
                                JSONArray jsonArrayCart = obj.getJSONArray("data");
                                for (int a = 0; a < jsonArrayCart.length();a++){
                                    JSONObject objCart = jsonArrayCart.getJSONObject(a);

                                    OrderItem orderItem = new OrderItem(
                                            objCart.getInt("order_item_id"),
                                            String.valueOf(objCart.getInt("price")),
                                            objCart.getString("order_kind"),
                                            objCart.getString("picture"),
                                            objCart.getString("weight"),
                                            objCart.getString("quantity"),
                                            objCart.getString("fish_item_name")
                                    );
                                    float price = (float) objCart.getInt("price");
                                    float quantity = Float.parseFloat(orderItem.getQuantity());
                                    float subtotal = price * quantity;

                                    HashMap<String,String> mapCart = new HashMap<String,String>();
                                    mapCart.put("fish_item_name",orderItem.getFish_item_name());
                                    mapCart.put("picture",orderItem.getPicture());
                                    mapCart.put("order_kind",orderItem.getOrder_kind());
                                    mapCart.put("quantity",orderItem.getQuantity());
                                    mapCart.put("subtotal", String.valueOf(subtotal));
                                    mapCart.put("id",String.valueOf(orderItem.getOrder_item_id()));

                                    listCartData.add(mapCart);
                                    // ADAPTERVIEW KE LISTVIEW HINGGA SET ADAPTER
                                    CartAdapter cartAdapter = new CartAdapter(CartActivity.this,listCartData);
                                    lvCart.setAdapter(cartAdapter);
                                }
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "message", Toast.LENGTH_SHORT).show();
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
