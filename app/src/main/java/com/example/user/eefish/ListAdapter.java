package com.example.user.eefish;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Rafif on 14/10/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    Context mContext;
    ArrayList<HashMap<String,String >> mListDataIkan;
    public ListAdapter(KategoriActivity kategoriActivity, ArrayList<HashMap<String, String>> listDataIkan) {
        this.mContext = kategoriActivity;
        this.mListDataIkan = listDataIkan;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ikan,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return mListDataIkan.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        TextView txtFishName, txtFishColectivePrice;
        ImageView imgFishImage;

        public ViewHolder(View itemView) {
            super(itemView);

            txtFishName = (TextView) itemView.findViewById(R.id.tvTitleIkan);
            txtFishColectivePrice = (TextView) itemView.findViewById(R.id.tvPriceIkan);
            imgFishImage = (ImageView) itemView.findViewById(R.id.ivIkan);
        }

    }
}
