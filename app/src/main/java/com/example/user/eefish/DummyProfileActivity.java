package com.example.user.eefish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.eefish.Controller.SessionManager;

import java.util.HashMap;

public class DummyProfileActivity extends AppCompatActivity {

    TextView nameTV,usernameTV,emaiilTV,addressTV,identitynumberTV,postcodeTV,phonenumberTV;

    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_profile);
        GetAllTextViewFromLayout();

        session = new SessionManager(getApplicationContext());
        session.checkLogin();

        SetAllUserBiodataToTextView();

    }

    private void SetAllUserBiodataToTextView() {
        HashMap<String, String> user = session.getUserDetails();

        nameTV.setText(user.get(SessionManager.KEY_NAME));
        emaiilTV.setText(user.get(SessionManager.KEY_EMAIL));
        usernameTV.setText(user.get(SessionManager.KEY_USERNAME));
        identitynumberTV.setText(user.get(SessionManager.KEY_iDENTITY_NUMBER));
        addressTV.setText(user.get(SessionManager.KEY_ADDRESS));
        postcodeTV.setText(user.get(SessionManager.KEY_POSTCODE));
        phonenumberTV.setText(user.get(SessionManager.KEY_PHONE_NUUMBER));
    }

    private void GetAllTextViewFromLayout() {
        nameTV = (TextView) findViewById(R.id.nameprofile);
        usernameTV = (TextView) findViewById(R.id.usernameprofile);
        emaiilTV = (TextView) findViewById(R.id.emailprofile);
        addressTV = (TextView) findViewById(R.id.addressprofile);
        identitynumberTV = (TextView) findViewById(R.id.identitynumber);
        postcodeTV = (TextView) findViewById(R.id.postcodeprofile);
        phonenumberTV = (TextView) findViewById(R.id.phonenumberprofile);
    }
}
