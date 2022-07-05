package com.example.myapplication6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;

public class FunFun extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funfun);



        Bitmap b = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("byteArray"),0,getIntent().getByteArrayExtra("byteArray").length);


        PhotoView funfun = findViewById(R.id.funfun);
        funfun.setImageBitmap(b);



        ImageView backbutton = (ImageView)findViewById(R.id.backbutton);

        backbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });




    }

    public boolean dispatchTouchEvent(MotionEvent event) {

        ImageView backbutton = (ImageView)findViewById(R.id.backbutton);
        int shortAnimationDuration;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(backbutton.getVisibility() == View.VISIBLE) {
                    backbutton.setVisibility(View.GONE);
                }else{backbutton.setVisibility(View.VISIBLE);}

                break;

            case MotionEvent.ACTION_MOVE:
                backbutton.setVisibility(View.GONE);
                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(event);
    }
}
