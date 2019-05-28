package com.example.mahanthesh.s_kart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingsFragment extends Fragment {

    private FirebaseAuth firebaseAuth;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //initialise firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        //getting user details
        FirebaseUser user = firebaseAuth.getCurrentUser();

        View view =  inflater.inflate(R.layout.fragment_settings, container, false);
        TextView Userlabel = (TextView) view.findViewById(R.id.UserTextview);
        final Button btn_Logout = (Button) view.findViewById(R.id.btn_logout);

        Userlabel.setText("Welcome "+user.getEmail());



        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btn_Logout){
                    firebaseAuth.signOut();

                    getActivity().finish();

                    startActivity(new Intent(getActivity(), Login.class));
                }

            }
        });


        return view;
    }
}
