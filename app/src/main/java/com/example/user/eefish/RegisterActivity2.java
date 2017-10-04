package com.example.user.eefish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class RegisterActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register2_layout);
        Button btnregister = (Button)findViewById(R.id.btn_Register_action);
        final Intent startLogin = new Intent(RegisterActivity2.this,LoginActivity.class);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kondisi;
                EditText inputFullname = (EditText) findViewById(R.id.edtText_Register_nama);
                EditText inputnoktp = (EditText) findViewById(R.id.edtText_Register_NoKTP);
                EditText inputaddress = (EditText) findViewById(R.id.edtText_Register_alamat);
                EditText inputkodepos = (EditText) findViewById(R.id.edtText_Register_poskode);

                String nama = inputFullname.getText().toString().trim();
                String noktp =  inputnoktp.getText().toString().trim();
                String address = inputaddress.getText().toString().trim();
                int kodepos = Integer.parseInt(inputkodepos.getText().toString().trim());

                if (nama.isEmpty() && noktp.isEmpty() && address.isEmpty() && kodepos == 0){
                    Toast.makeText(RegisterActivity2.this, "Semua Data Harus di Isi", Toast.LENGTH_SHORT).show();
                }else {
                    doRegister();
                    startActivity(startLogin);
                }
            }
        });
    }

    private void doRegister() {

        EditText inputFullname = (EditText) findViewById(R.id.edtText_Register_nama);
        EditText inputnoktp = (EditText) findViewById(R.id.edtText_Register_NoKTP);
        EditText inputaddress = (EditText) findViewById(R.id.edtText_Register_alamat);
        EditText inputkodepos = (EditText) findViewById(R.id.edtText_Register_poskode);

        final String nama = inputFullname.getText().toString().trim();
       final String noktp =  inputnoktp.getText().toString().trim();
       final String address = inputaddress.getText().toString().trim();
       final int kodepos = Integer.parseInt(inputkodepos.getText().toString().trim());

        Intent mylocalintent = getIntent();
        Bundle myBundle = mylocalintent.getExtras();


        final String email = myBundle.getString("email");
        final String username = myBundle.getString("username");
        final String password = myBundle.getString("password");
        final String telepon = myBundle.getString("telepon");


        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);

                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
                                JSONObject userJson = obj.getJSONObject("user");

                                //creating a new user object
                                User user = new User(
                                        userJson.getInt("id"),
                                        userJson.getInt("kodepos"),
                                        userJson.getString("nama"),
                                        userJson.getString("email"),
                                        userJson.getString("password"),
                                        userJson.getString("alamat"),
                                        userJson.getString("noktp"),
                                        userJson.getString("username"),
                                        userJson.getString("telepon")
                                );

                                //storing the user in shared preferences

                                //starting the profile activity
                                Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();
                            } else {
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
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username",username);
                params.put("address",address);
                params.put("nama", nama);
                params.put("email", email);
                params.put("password", password);
                params.put("phone_number",telepon);
                params.put("identity_number",noktp);
                return params;
            }
        };
        AppController.getInstance(this).addToRequestQueue(stringRequest);
        // ketika register berhasil maka akan return 1 untuk parameter pindah aktifiti


    }
}
