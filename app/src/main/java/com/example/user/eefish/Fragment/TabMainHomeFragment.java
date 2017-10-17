package com.example.user.eefish.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.user.eefish.Activity.KategoriActivity;
import com.example.user.eefish.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabMainHomeFragment extends Fragment {

    CardView laut, tawar, udang;
    ImageButton ivLaut, ivTawar, ivUdang;
    static Bundle kategoriBundle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        kategoriBundle = new Bundle();

        // Inflate the layout for this fragment
//        Context konteks;
//        konteks = getActivity();
        View rootView = inflater.inflate(R.layout.fragment_main_tabs_home, container, false);
        ivLaut = (ImageButton) rootView.findViewById(R.id.bAirLaut);
        ivTawar = (ImageButton) rootView.findViewById(R.id.bAirTawar);
        ivUdang = (ImageButton) rootView.findViewById(R.id.bUdang);

        ivLaut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kategoriBundle.putInt("id",1);
                goToAttract(view);

            }
        });
        ivTawar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kategoriBundle.putInt("id", 2);
               goToAttract(view);
            }
        });
        ivUdang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kategoriBundle.putInt("id", 3);
                goToAttract(view);
            }
        });

        return rootView;
    }

    public void goToAttract(View v)
    {
        Intent intent = new Intent(getActivity(), KategoriActivity.class);
        intent.putExtras(kategoriBundle);
        startActivity(intent);
    }
}
