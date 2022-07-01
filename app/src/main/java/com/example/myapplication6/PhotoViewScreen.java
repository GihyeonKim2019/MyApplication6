package com.example.myapplication6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;

public class PhotoViewScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoview);

        Intent intent = getIntent();

        int imageRecieved1 = intent.getIntExtra("image",0);

        PhotoView photoView = findViewById(R.id.photoView);
        photoView.setImageResource(imageRecieved1);

        ImageView backbutton = (ImageView)findViewById(R.id.backbutton);

        backbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}
