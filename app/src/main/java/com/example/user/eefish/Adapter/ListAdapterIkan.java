package com.example.user.eefish.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.eefish.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Rafif on 14/10/2017.
 */

public class ListAdapterIkan extends RecyclerView.Adapter<ListAdapterIkan.ViewHolder> {

    Context mContext;
    ArrayList<HashMap<String,String >> mListDataIkan;
    public ListAdapterIkan(Context context, ArrayList<HashMap<String, String>> listDataIkan) {
        this.mContext = context;
        this.mListDataIkan = listDataIkan;
    }

    @Override
    public ListAdapterIkan.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ikan,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapterIkan.ViewHolder holder, int position) {
        holder.txtFishName.setText(mListDataIkan.get(position).get("fish_name"));
        holder.txtFishColectivePrice.setText(mListDataIkan.get(position).get("colective_price"));
    }

    @Override
    public int getItemCount() {
        return mListDataIkan.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        TextView txtFishName, txtFishColectivePrice;
        ImageView imgFishImage;
        LinearLayout ikanLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            txtFishName = (TextView) itemView.findViewById(R.id.tvTitleIkan);
            txtFishColectivePrice = (TextView) itemView.findViewById(R.id.tvPriceIkan);
            imgFishImage = (ImageView) itemView.findViewById(R.id.ivIkan);
            ikanLayout = (LinearLayout) itemView.findViewById(R.id.layoutikanbykategori);
        }



    }
}
