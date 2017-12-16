package com.example.user.eefish.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.eefish.R;

/**
 * Created by Nadian on 12/16/2017.
 */

public class RVHistoryOnProgressAdapter extends RecyclerView.Adapter<RVHistoryOnProgressAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        TextView alamatOrder, tanggalOrder, waktuOrder;
        public ViewHolder(View itemView) {
            alamatOrder = itemView.findViewById(R.id.)
            super(itemView);
        }
    }

}


