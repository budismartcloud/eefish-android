package com.example.user.eefish.Fragment;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.eefish.Controller.SessionManager;
import com.example.user.eefish.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Nadian on 12/16/2017.
 */

public class HistoryOnProgressFragment extends Fragment {

    RecyclerView rvHistory;
    SessionManager session;
    private ArrayList<HashMap<String, String>> listHistoryOnProgress;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_history_fragment,container,false);
        final Calendar calendar = Calendar.getInstance();
        session = new SessionManager(getActivity());
        listHistoryOnProgress = new ArrayList<HashMap<String,String>>();

        rvHistory = rootView.findViewById(R.id.rv_tab_history_fragment);
        LinearLayoutManager llmHistoryOnProgress = new LinearLayoutManager(rootView.getContext());


        getHistoryOrderOnProgress(session.getIdUser());
        return rootView;
    }

    private void getHistoryOrderOnProgress(int idUser) {

    }
}
