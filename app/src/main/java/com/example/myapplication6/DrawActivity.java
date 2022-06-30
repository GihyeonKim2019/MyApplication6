package com.example.myapplication6;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DrawActivity  extends AppCompatActivity {
    TextView showXY;
    int posX, posY;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        setContentView(new SetView(this));
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //손가락이 화면에 닿았을 때
            posX = (int) event.getX();
            posY = (int) event.getY();
            showXY.setText("X: " + posX + ",  Y: " + posY);
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            //드래그 상태
            posX = (int) event.getX();
            posY = (int) event.getY();
            showXY.setText("X: " + posX + ",  Y: " + posY);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            //손떼면?
        }

        return true;
    }
}
