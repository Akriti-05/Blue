package com.techster.aashaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.techster.aashaapp.databinding.ActivityAboutBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class aboutActivity extends AppCompatActivity {
    ActivityAboutBinding binding;

    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(aboutActivity.this, SettingsActivity.class);
                startActivity(i);
            }
        });


        binding.btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(aboutActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        binding.btnCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(aboutActivity.this, MusicActivity.class);
                startActivity(i);
            }
        });

        binding.btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(aboutActivity.this, TipsActivity.class);
                startActivity(i);
            }
        });


        binding.btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(aboutActivity.this, IntroActivity.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
