package com.example.user.eefish.Activity;

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
import com.example.user.eefish.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivityStep2 extends AppCompatActivity {

    EditText inputFullname,inputnoktp, inputaddress, inputkodepos;
    Button btnregister;
    String nama, noktp,address,email,username,password,telepon,kodepos;
    Intent startLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register2_layout);

        btnregister = (Button)findViewById(R.id.btn_Register_action);
        startLogin = new Intent(RegisterActivityStep2.this,LoginActivity.class);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetAllEditTextFromLayout();

                SetNamaValueDariEditTextkeStringnama();

                SetNomerKTPValueDariEditTextkeStringnoktp();

                SetaddressValueDariEditTextkeStringaddress();

                SetkodeposValueDariEditTextkeINTkodepos();

                if (nama.isEmpty() && noktp.isEmpty() && address.isEmpty() && kodepos.isEmpty()){
                    Toast.makeText(RegisterActivityStep2.this, "Semua Data Harus di Isi", Toast.LENGTH_SHORT).show();
                }else {
                    doRegister();
                    startActivity(startLogin);
                }
            }
        });
    }

    private void SetkodeposValueDariEditTextkeINTkodepos() {
        kodepos = inputkodepos.getText().toString().trim();
    }

    private void SetaddressValueDariEditTextkeStringaddress() {
        address = inputaddress.getText().toString().trim();
    }

    private void SetNomerKTPValueDariEditTextkeStringnoktp() {
        noktp =  inputnoktp.getText().toString().trim();
    }

    private void SetNamaValueDariEditTextkeStringnama() {
        nama = inputFullname.getText().toString().trim();
    }

    private void GetAllEditTextFromLayout() {
        inputFullname = (EditText) findViewById(R.id.edtText_Register_nama);
        inputnoktp = (EditText) findViewById(R.id.edtText_Register_NoKTP);
        inputaddress = (EditText) findViewById(R.id.edtText_Register_alamat);
        inputkodepos = (EditText) findViewById(R.id.edtText_Register_poskode);
    }

    private void doRegister() {

        GetAllEditTextFromLayout();

        SetNamaValueDariEditTextkeStringnama();

        SetNomerKTPValueDariEditTextkeStringnoktp();

        SetaddressValueDariEditTextkeStringaddress();

        SetkodeposValueDariEditTextkeINTkodepos();

        Intent mylocalintent = getIntent();
        Bundle myBundle = mylocalintent.getExtras();

        GetAllValueBundleDariExtras(myBundle);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);

                            //if no error in response
                            if (obj.getInt("code") == 302) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
//                                JSONObject userJson = obj.getJSONObject("user");
//                                //creating a new user object
//                                User user = new User(
//                                        userJson.getInt("id"),
//                                        userJson.getString("username"),
//                                        userJson.getString("name"),
//                                        userJson.getString("password"),
//                                        userJson.getString("identity_number"),
//                                        userJson.getString("address"),
//                                        userJson.getString("phone_number"),
//                                        userJson.getString("email"),
//                                        userJson.getString("postcode")
//                                );

                                //storing the user in shared preferences

                                //starting the profile activity
                                //Toast.makeText(getApplicationContext(), "messge", Toast.LENGTH_SHORT).show();
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
                params.put("name",nama);
                params.put("password", password);
                params.put("identity_number", noktp);
                params.put("address", address);
                params.put("phone_number",telepon);
                params.put("email",email);
                params.put("postcode", kodepos);
                return params;
            }
        };
        AppController.getInstance(this).addToRequestQueue(stringRequest);
        // ketika register berhasil maka akan return 1 untuk parameter pindah aktifiti


    }

    private void GetAllValueBundleDariExtras(Bundle myBundle) {
        email = myBundle.getString("email");
        username = myBundle.getString("username");
        password = myBundle.getString("password");
        telepon = myBundle.getString("telepon");
    }
}
