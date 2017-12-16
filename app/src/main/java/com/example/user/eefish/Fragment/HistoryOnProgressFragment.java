package com.example.user.eefish.Fragment;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.eefish.Controller.SessionManager;
import com.example.user.eefish.R;

import java.util.Calendar;

/**
 * Created by Nadian on 12/16/2017.
 */

public class HistoryOnProgressFragment extends Fragment {

    RecyclerView rvHistory;
    SessionManager sessionManager;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_history_fragment,container,false);
        final Calendar calendar = Calendar.getInstance();
        sessionManager = new SessionManager(getActivity());

        rvHistory = rootView.findViewById(R.id.rv_tab_history_fragment);

        return rootView;
    }
}
