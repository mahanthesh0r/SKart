package com.example.mahanthesh.s_kart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductStoreAdapter extends RecyclerView.Adapter<ProductStoreAdapter.ViewHolder>  {

    private Context context;
    private List<ProductDetailObjects> list;

    public ProductStoreAdapter(Context context, List<ProductDetailObjects> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.storelist, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ProductDetailObjects productDetailObjects = list.get(i);

        viewHolder.store_name.setText(productDetailObjects.getStore_name());
        viewHolder.store_price.setText(productDetailObjects.getStore_price());
        String storeURL = "<a href='" +productDetailObjects.getStore_url() + "'>Buy now</a>";
        viewHolder.productName.setText(Html.fromHtml(storeURL));
        Picasso.with(context).load(productDetailObjects.getStore_img_url())
                .into(viewHolder.store_logo);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ImageView store_logo;
        public TextView store_name, store_price, productName, Productbrand;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            store_logo = itemView.findViewById(R.id.store_img);
            store_name = itemView.findViewById(R.id.TV_store_name);
            store_price = itemView.findViewById(R.id.TV_store_price);
            productName = itemView.findViewById(R.id.TV_product_name);
            productName.setClickable(true);
            productName.setMovementMethod(LinkMovementMethod.getInstance());



        }
    }
}
