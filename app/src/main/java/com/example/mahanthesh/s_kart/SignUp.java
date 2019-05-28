package com.example.mahanthesh.s_kart;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //defining views
    private EditText editTextEmail;
    private EditText editTextpassword;
    private Button   btnSignup;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //initialize firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        //initialize views
        editTextEmail = (EditText) findViewById(R.id.et_usernameSignUp);
        editTextpassword = (EditText) findViewById(R.id.et_passwordSignUp);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        progressDialog = new ProgressDialog(this);


        //Sign up Button listener
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                registerUser();

            }
        });

    }

    public void loginpage(View view){

        Intent i = new Intent(SignUp.this,Login.class);
        startActivity(i);
        this.finish();

    }

    private void registerUser(){


        //getting email and password
        String email = editTextEmail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //Can implement progress bar
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();



        //Creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                //checking if success
                if(task.isSuccessful()){
                    Toast.makeText(SignUp.this,"Successfully Registered",Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(),Home.class));
                }else{
                    //display some message here
                    Toast.makeText(SignUp.this,"Registration Error",Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();

            }
        });

    }
}
