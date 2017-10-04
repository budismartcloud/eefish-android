package com.example.user.eefish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        Button btnNext = (Button) findViewById(R.id.btn_Register_next_act1);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText inputEmail = (EditText) findViewById(R.id.edtText_Register_email);
                EditText inputUsername = (EditText) findViewById(R.id.edtText_Register_username);
                EditText inputPassword = (EditText) findViewById(R.id.edtText_Register_password);
                EditText inputTelepon = (EditText) findViewById(R.id.edtText_Register_telepon);
                EditText inputKonfirmasi = (EditText) findViewById(R.id.edtText_Register_konfimasiPassword);

                String email = inputEmail.getText().toString();
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();
                String telepon = inputTelepon.getText().toString();
                String konfirmasi = inputKonfirmasi.getText().toString();

                if (!email.isEmpty() && !username.isEmpty() && !password.isEmpty() && !telepon.isEmpty() && !konfirmasi.isEmpty())
                {
                    if (password.equals(konfirmasi))
                    {
                        Bundle bundleUser = new Bundle();
                        bundleUser.putString("username",username);
                        bundleUser.putString("email",email);
                        bundleUser.putString("telepon",telepon);
                        bundleUser.putString("password",password);

                        Intent mynextIntent = new Intent(RegisterActivity.this,RegisterActivity2.class);
                        mynextIntent.putExtras(bundleUser);
                        startActivityForResult(mynextIntent,1122);

                    } else {
                        Toast.makeText(RegisterActivity.this, "password dan konfirmasi password tidak sama",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Data harus di isi semua",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
