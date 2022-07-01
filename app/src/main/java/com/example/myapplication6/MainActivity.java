package com.example.myapplication6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;

    private int[] tabIcons = {
            R.drawable.ic_baseline_contacts_24,
            R.drawable.ic_baseline_collections_24,
            R.drawable.ic_baseline_create_24
    };







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);



        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(Fragment1.newInstance(0));
        fragments.add(Fragment2.newInstance(1));
        fragments.add(Fragment3.newInstance(2));



        //tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_contacts_24);
        //tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_collections_24);
        //tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_create_24);


        viewPager2 = (ViewPager2) findViewById(R.id.viewPager2_container);

        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this, fragments);
        viewPager2.setAdapter(viewPager2Adapter);



        final List<String> tabElement = Arrays.asList("Tab1","Tab2","Tab3");



        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                TextView textView = new TextView(MainActivity.this);
                textView.setText(tabElement.get(position));

                tab.setIcon(tabIcons[position]);


            }
        }).attach();








    }

    private void setupTabIcon() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    public void onButton1Clicked(View v) {
        Toast.makeText(this,"전화 걸기", Toast.LENGTH_LONG).show();
    }

    public void onButton2Clicked(View v) {
        Toast.makeText(this,"문자 보내기", Toast.LENGTH_LONG).show();
    }

    public void onButton3Clicked(View v) {
        Intent intent = new Intent(this, DrawActivity.class);
        startActivity(intent);
    }


}