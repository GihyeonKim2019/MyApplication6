package com.example.myapplication6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment implements View.OnTouchListener{

    TextView showXY;
    int posX, posY;

    public static Fragment3 newInstance(int number) {
        Fragment3 fragment3 = new Fragment3();
        Bundle bundle = new Bundle();
        bundle.putInt("number", number);
        fragment3.setArguments(bundle);
        return fragment3;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            int num = getArguments().getInt("number");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        showXY = (TextView) view.findViewById(R.id.showXY);
        showXY.setOnTouchListener(this);
        return view;
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
