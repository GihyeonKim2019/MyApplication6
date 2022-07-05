package com.example.myapplication6;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;

public class FunFunFun extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        int x = intent.getIntExtra("image",0);

        setContentView(R.layout.activity_funfunfun);

        PhotoView pv = (PhotoView)findViewById(R.id.funfunphotoview);

        pv.setImageResource(x);


    }
}
