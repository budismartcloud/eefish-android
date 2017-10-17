package com.example.user.eefish.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.eefish.Controller.SessionManager;
import com.example.user.eefish.R;

import java.util.HashMap;


public class TabMainProfileFragment extends Fragment {

    TextView nameTV,usernameTV,emaiilTV,addressTV,identitynumberTV,postcodeTV,phonenumberTV;
    Button mlogout;
    SessionManager session;

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        session = new SessionManager(getContext());
        View rootView = inflater.inflate(R.layout.fragment_main_tab_profile, container, false);
        GetAllTextViewfromFragment_tab_profile(rootView);
        SetAllUserBiodataToTextView();
        mlogout = (Button) rootView.findViewById(R.id.logoutButtonProfile);

        mlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.logoutUser();

            }
        });

        return rootView;
        }

    private void GetAllTextViewfromFragment_tab_profile(View rootView) {
        nameTV = (TextView) rootView.findViewById(R.id.nameprofile);
        usernameTV = (TextView) rootView.findViewById(R.id.usernameprofile);
        emaiilTV = (TextView) rootView.findViewById(R.id.emailprofile);
        addressTV = (TextView) rootView.findViewById(R.id.addressprofile);
        identitynumberTV = (TextView) rootView.findViewById(R.id.identitynumber);
        postcodeTV = (TextView) rootView.findViewById(R.id.postcodeprofile);
        phonenumberTV = (TextView) rootView.findViewById(R.id.phonenumberprofile);
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


}
