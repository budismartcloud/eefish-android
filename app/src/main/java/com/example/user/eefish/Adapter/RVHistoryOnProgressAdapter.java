package com.example.user.eefish.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.eefish.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nadian on 12/16/2017.
 */

public class RVHistoryOnProgressAdapter extends RecyclerView.Adapter<RVHistoryOnProgressAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<HashMap<String,String >> mListDataHistoryOnprogress;
    private Bundle mBundle;

    public RVHistoryOnProgressAdapter(Context mContext, ArrayList<HashMap<String, String>> mListDataHistoryOnprogress) {
        this.mContext = mContext;
        this.mListDataHistoryOnprogress = mListDataHistoryOnprogress;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_in_history,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.waktuOrder.setText(mListDataHistoryOnprogress.get(position).get("time"));
        holder.tanggalOrder.setText(mListDataHistoryOnprogress.get(position).get("date"));
        holder.alamatOrder.setText(mListDataHistoryOnprogress.get(position).get("address"));
    }

    @Override
    public int getItemCount() {
        return mListDataHistoryOnprogress.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        TextView alamatOrder, tanggalOrder, waktuOrder;
        public ViewHolder(View itemView) {
            super(itemView);
            alamatOrder = itemView.findViewById(R.id.tv_history_onprogress_address);
            tanggalOrder= itemView.findViewById(R.id.tv_history_onprogress_date);
            waktuOrder= itemView.findViewById(R.id.tv_history_onprogress_date);
        }
    }

}


