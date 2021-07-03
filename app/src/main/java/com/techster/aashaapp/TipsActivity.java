package com.techster.aashaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.techster.aashaapp.Adapters.PagerAdapter;
import com.techster.aashaapp.Fragments.About_Us;
import com.techster.aashaapp.Fragments.THERAPIST_LIST;
import com.techster.aashaapp.Fragments.Tips;

public class TipsActivity extends AppCompatActivity  {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        getSupportActionBar().hide();
        tabLayout = (TabLayout) findViewById(R.id.Tablayout);
        viewPager = (ViewPager) findViewById(R.id.ViewPager);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);




    }
    public  void setUpViewPager(ViewPager viewPager){
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new Tips(),"TIPS");
        pagerAdapter.addFragment(new THERAPIST_LIST(),"THERAPIST LIST");
        pagerAdapter.addFragment(new About_Us(),"ABOUT US");
        viewPager.setAdapter(pagerAdapter);

    }
}