package com.example.mahanthesh.s_kart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductDetails extends AppCompatActivity {

    private static final String API_KEY = "<API-KEY>";
    private String DetailURL = "https://price-api.datayuge.com/api/v1/compare/detail?api_key=vyQYT02PZupRHICcasMCaRHIL2vObKNjrrj&id=";
    private String URL;


    private List<ProductDetailObjects> productDetailObjectsList;

    private RecyclerView mRV;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private RecyclerView.Adapter adapter;
    private TextView tv_specs;
    





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        mRV = findViewById(R.id.RV_stores);
        productDetailObjectsList = new ArrayList<>();
        adapter = new ProductStoreAdapter(getApplicationContext(),productDetailObjectsList);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mRV.getContext(), linearLayoutManager.getOrientation());

        mRV.setHasFixedSize(true);
        mRV.setLayoutManager(linearLayoutManager);
        mRV.addItemDecoration(dividerItemDecoration);
        mRV.setAdapter(adapter);


        ImageView pdetail_img = (ImageView) findViewById(R.id.pdetail_img);
        TextView pdetail_name = (TextView) findViewById(R.id.pdetail_name);
        tv_specs = findViewById(R.id.TV_product_model);








        Intent intent = getIntent();
        final String pdetailName = intent.getStringExtra(ProductAdapter.KEY_PNAME);

        String image = intent.getStringExtra(ProductAdapter.KEY_IMAGE);
        String pid = intent.getStringExtra(ProductAdapter.KEY_PID);

        URL = DetailURL+pid;
        Log.e("URL", URL);
        loadProductDetails();





        Picasso.with(this).load(image).into(pdetail_img);



        pdetail_name.setText(pdetailName);


    }

    public void loadProductDetails() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                    tv_specs.setText(jsonObject1.getString("product_model"));
                    JSONArray array = jsonObject1.getJSONArray("stores");









                   for (int i = 0; i <array.length(); ++i) {
                            JSONObject jo = array.getJSONObject(i);
                            for(Iterator<String> iter = jo.keys();iter.hasNext();){


                                String key = iter.next();
                                String value = jo.getString(key);



                                JSONObject jo2 = new JSONObject(value);



                                ProductDetailObjects productDetailObjects = new ProductDetailObjects();
                                productDetailObjects.setStore_name(jo2.getString("product_store"));
                                productDetailObjects.setStore_price(jo2.getString("product_price"));
                                productDetailObjects.setStore_url(jo2.getString("product_store_url"));
                                productDetailObjects.setStore_img_url(jo2.getString("product_store_logo"));

                                productDetailObjectsList.add(productDetailObjects);

                            }



                }



                } catch (JSONException e) {

                }
                adapter.notifyDataSetChanged();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
