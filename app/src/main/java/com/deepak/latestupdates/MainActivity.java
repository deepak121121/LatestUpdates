package com.deepak.latestupdates;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem tabItem1,tabItem2,tabItem3,tabItem4,tabItem5,tabItem6;
    ViewPager viewPager;
    pageAdapter adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById( R.id.Tool );
        tabLayout=findViewById( R.id.Tab );
        tabItem1=findViewById( R.id.home );
        tabItem2=findViewById( R.id.sports );
        tabItem3=findViewById( R.id.health );
        tabItem4=findViewById( R.id.Science );
        tabItem5=findViewById( R.id.Technology );
        tabItem6=findViewById( R.id.Entertainment );
        viewPager=findViewById( R.id.View );
        adapter=new pageAdapter( getSupportFragmentManager(),tabLayout.getTabCount() );
        viewPager.setAdapter( adapter );


        // this Lister is basically for select the item

        tabLayout.setOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem( tab.getPosition() );
                if(tab.getPosition()==0 || tab.getPosition()==1 ||tab.getPosition()==2 ||tab.getPosition()==3 ||tab.getPosition()==4 ||tab.getPosition()==5)
                {
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );
        // this Lister is basically for scroll the view page

        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabLayout ) );


    }
}