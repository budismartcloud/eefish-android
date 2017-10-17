package com.example.user.eefish.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.eefish.R;

public class RegisterActivityStep1 extends AppCompatActivity {

    EditText inputEmail,inputUsername,inputPassword,inputTelepon,inputKonfirmasi;
    String email,username,password,telepon,konfirmasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        Button btnNext = (Button) findViewById(R.id.btn_Register_next_act1);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetAllEditTextFromLayout();

                SetEmailValueDariEditTextinputEmail();

                SetusernameValueDariEditTextinputUsername();

                SetpasswordValueDariEditTextinputPassword();

                SetteleponValueDariEditTextinputtelepon();

                SetkonfirmasiPasswordValueDariEditTextKonfimasi();

                if (!email.isEmpty() && !username.isEmpty() && !password.isEmpty() && !telepon.isEmpty() && !konfirmasi.isEmpty())
                {
                    if (password.equals(konfirmasi))
                    {
                        Bundle bundleUser = new Bundle();
                        bundleUser.putString("username",username);
                        bundleUser.putString("email",email);
                        bundleUser.putString("telepon",telepon);
                        bundleUser.putString("password",password);

                        Intent mynextIntent = new Intent(RegisterActivityStep1.this,RegisterActivityStep2.class);
                        mynextIntent.putExtras(bundleUser);
                        startActivityForResult(mynextIntent,1122);

                    } else {
                        Toast.makeText(RegisterActivityStep1.this, "password dan konfirmasi password tidak sama",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivityStep1.this, "Data harus di isi semua",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void SetkonfirmasiPasswordValueDariEditTextKonfimasi() {
        konfirmasi = inputKonfirmasi.getText().toString();
    }

    private void SetteleponValueDariEditTextinputtelepon() {
        telepon = inputTelepon.getText().toString();
    }

    private void SetpasswordValueDariEditTextinputPassword() {
        password = inputPassword.getText().toString();
    }

    private void SetusernameValueDariEditTextinputUsername() {
        username = inputUsername.getText().toString();
    }

    private void SetEmailValueDariEditTextinputEmail() {
        email = inputEmail.getText().toString();
    }

    private void GetAllEditTextFromLayout() {
        inputEmail = (EditText) findViewById(R.id.edtText_Register_email);
        inputUsername = (EditText) findViewById(R.id.edtText_Register_username);
        inputPassword = (EditText) findViewById(R.id.edtText_Register_password);
        inputTelepon = (EditText) findViewById(R.id.edtText_Register_telepon);
        inputKonfirmasi = (EditText) findViewById(R.id.edtText_Register_konfimasiPassword);
    }
}
