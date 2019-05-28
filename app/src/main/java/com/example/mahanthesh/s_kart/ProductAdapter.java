package com.example.mahanthesh.s_kart;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;


import com.squareup.picasso.Picasso;


import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    public static final String KEY_PNAME = "pname";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_PID = "product_id";



    private List<ProductList> productLists;
    private Context context;

    public ProductAdapter(List<ProductList> productLists,Context context){
        this.productLists = productLists;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //this method will be called whenever our ViewHolder is created

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_list,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        //this method will bind the data to the ViewHolder from which it'll be shown to other views

        final ProductList productList = productLists.get(i);
        viewHolder.pname.setText(productList.getPname());
        viewHolder.price.setText(productList.getPrice());
        viewHolder.ratingBar.setRating(productList.getRating());

        Picasso.with(context).load(productList.getImg_url())
                .into(viewHolder.img_url);

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductList productList1 = productLists.get(i);
                Intent in = new Intent(v.getContext(), ProductDetails.class);
                in.putExtra(KEY_PNAME,productList1.getPname());
                in.putExtra(KEY_IMAGE,productList1.getImg_url());
                in.putExtra(KEY_PID,productList1.getPid());
                v.getContext().startActivity(in);


            }
        });

    }

    @Override
    public int getItemCount()    {
        return productLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView pname;
        TextView price;
        ImageView img_url;
        RatingBar ratingBar;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //initialize the view objects
             pname = (TextView) itemView.findViewById(R.id.product_name);
             img_url = (ImageView) itemView.findViewById(R.id.imageView);
             linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
             price = (TextView) itemView.findViewById(R.id.TV_price);
             ratingBar = (RatingBar) itemView.findViewById(R.id.rating);

        }
    }
}
