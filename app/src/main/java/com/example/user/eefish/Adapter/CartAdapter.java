package com.example.user.eefish.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.user.eefish.R;
import static com.example.user.eefish.Controller.AppConfig.ROOT_URL;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * Created by Rafif on 14/10/2017.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<HashMap<String,String >> mListdataCart;


    public CartAdapter(Context context, ArrayList<HashMap<String, String>> mlistdataCart) {
        this.mContext = context;
        this.mListdataCart = mlistdataCart;
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_cart,null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CartAdapter.ViewHolder holder, int position) {

//        Glide.with(mContext)
//                .load(ROOT_URL + mListdataCart.get(position).get("picture"))
//                .crossFade()
//                .into(holder.imgFishImage);
//        holder.txtFishName.setText(mListdataCart.get(position).get("fish_item_name"));
//        holder.tvHargaikan.setText("Rp."+mListdataCart.get(position).get("price")+",00");
//        holder.setId(Integer.parseInt(mListdataCart.get(position).get("id")));
//        holder.tvJenisPembelian.setText(mListdataCart.get(position).get("order_kind"));
////        holder.tvSubtotal.setText("Rp."+mListdataCart.get(position).get("subtotal")+",00");
//        holder.tvOrderperItem.setText(mListdataCart.get(position).get("quantity"));

    }

    @Override
    public int getItemCount() {
        return mListdataCart.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        TextView txtFishName,tvJenisPembelian;
        TextView tvHargaikan,tvSubtotal,tvOrderperItem;
        ImageView imgFishImage;
        LinearLayout layoutCart;
        Button butAddquantity, butReducquantity;
        int id;

        public int getId()
        {
            return id;
        }
        public void setId(int id)
        {
            this.id = id;
        }

        public ViewHolder(View itemView) {
            super(itemView);

            txtFishName = (TextView) itemView.findViewById(R.id.tvNamaIkan);
            tvJenisPembelian = (TextView) itemView.findViewById(R.id.tv_jenis_pembelian);
            imgFishImage = (ImageView) itemView.findViewById(R.id.iv_ikan_i);
            layoutCart = (LinearLayout) itemView.findViewById(R.id.layout_cart);
            tvHargaikan = (TextView) itemView.findViewById(R.id.tv_harga_item_i);
            tvSubtotal = (TextView) itemView.findViewById(R.id.tv_subtotal_i);
            tvOrderperItem = (TextView) itemView.findViewById(R.id.tvOrderItemperItem);

            butAddquantity = (Button) itemView.findViewById(R.id.bPlusPerItem);
            butReducquantity = (Button) itemView.findViewById(R.id.bMinusPerItem);

//            imgFishImage.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent detilActivity = new Intent(mContext , DetilIkanActivity.class);
//                    mBundle.putInt("id",getId());
//                    detilActivity.putExtras(mBundle);
//                    mContext.startActivity(detilActivity);
//                }
//            });
        }
    }
}
