package com.techster.aashaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.techster.aashaapp.Models.User;
import com.techster.aashaapp.databinding.ActivitySignUpactivityBinding;

import java.util.Objects;


public class signUPActivity extends AppCompatActivity {

    ActivitySignUpactivityBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        progressDialog = new ProgressDialog(signUPActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating your account");

        binding = ActivitySignUpactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();





        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();

                auth.createUserWithEmailAndPassword
                        (binding.Etemail.getText().toString(), binding.EtPassword.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();

                                if (task.isSuccessful()) {
                                    User user = new User(binding.EtuserName.getText().toString(),
                                            binding.Etemail.getText().toString(),
                                            binding.EtPassword.getText().toString());

                                    String id = Objects.requireNonNull(Objects.requireNonNull(task.getResult()).getUser()).
                                            getUid();
                                    database.getReference().child("Users").child(id).setValue(user);



                                    Intent intent = new Intent(signUPActivity.this, aboutActivity.class);
                                    startActivity(intent);


                                }
                                else {
                                    Toast.makeText(signUPActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


            }
        });
        binding.tvalreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signUPActivity.this, SignInActivity.class);
                startActivity(intent);

            }
        });


    }

}