package com.example.user.eefish.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.user.eefish.Activity.DetilIkanActivity;
import com.example.user.eefish.Activity.KategoriActivity;
import com.example.user.eefish.R;
import static com.example.user.eefish.Controller.AppConfig.ROOT_URL;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * Created by Rafif on 14/10/2017.
 */

public class ListAdapterIkan extends RecyclerView.Adapter<ListAdapterIkan.ViewHolder> {

    private Context mContext;
    private ArrayList<HashMap<String,String >> mListDataIkan;
    private Bundle mBundle;


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
        Glide.with(mContext)
                .load(ROOT_URL + mListDataIkan.get(position).get("picture"))
                .crossFade().placeholder(R.drawable.kategori_udang)
                .into(holder.imgFishImage);

        holder.txtFishName.setText(mListDataIkan.get(position).get("fish_name"));
        holder.txtFishColectivePrice.setText("Rp."+mListDataIkan.get(position).get("colective_price"));
        holder.setId(Integer.parseInt(mListDataIkan.get(position).get("id")));

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
        int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public ViewHolder(View itemView) {
            super(itemView);
            mBundle = new Bundle();
            txtFishName = (TextView) itemView.findViewById(R.id.tvTitleIkan1);
            txtFishColectivePrice = (TextView) itemView.findViewById(R.id.tvPriceIkan1);
            imgFishImage = (ImageView) itemView.findViewById(R.id.ivIkan1);
            ikanLayout = (LinearLayout) itemView.findViewById(R.id.layoutikanbykategori);

            imgFishImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detilActivity = new Intent(mContext , DetilIkanActivity.class);
                    mBundle.putInt("id",getId());
                    detilActivity.putExtras(mBundle);
                    mContext.startActivity(detilActivity);
                }
            });
        }
    }
}
