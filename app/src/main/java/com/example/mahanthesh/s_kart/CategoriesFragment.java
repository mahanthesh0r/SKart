package com.example.mahanthesh.s_kart;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CategoriesFragment extends Fragment {

    private RecyclerView firstRecyclerView;



    private String[] Sub_Category = {"Apparel & Accessories", "Baby & Toddler","Cameras & Optics", "Electronics", "Food, Beverages", "Furniture", "Hardware", "Health & Beauty", "Home & Garden", "Luggage & Bags", "Office Supplies", "Religious & Ceremonial", "Software", "Sporting Goods", "Toys & Games", "Vehicles & Parts"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        firstRecyclerView = (RecyclerView) view.findViewById(R.id.recycler);


        RecyclerView.LayoutManager firstLayoutManager = new LinearLayoutManager(getActivity());


        firstRecyclerView.setLayoutManager(firstLayoutManager);


        CategoryAdapter firstAdapter = new CategoryAdapter(getActivity(),Sub_Category);

        firstRecyclerView.setAdapter(firstAdapter);





        return view;
    }

}
