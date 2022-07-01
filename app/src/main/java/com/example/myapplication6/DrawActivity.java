package com.example.myapplication6;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class DrawActivity  extends AppCompatActivity {
    public PaintView paintView;
    private Button mDoneBtn;
    private ImageButton mClearBtn;
    TextView colorTextView;
    View colorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        colorTextView = findViewById(R.id.color_text_view);

        colorView = findViewById(R.id.color_view);

        ColorPickerView colorPickerView = findViewById(R.id.colorPickerView);
        colorPickerView.setColorListener(new ColorEnvelopeListener() {
            @Override
            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                colorTextView.setText(envelope.getHexCode());
                colorView.setBackgroundColor(envelope.getColor());
                paintView.set1_color(envelope.getColor());
            }
        });

        //완성화면으로, 그림결과 넘겨주기
//        mDoneBtn = (Button)findViewById(R.id.done_btn);
//        mDoneBtn.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(
//                        getApplicationContext(),
//                        az.class);
//
//                startActivity(intent);
//
//            }
//        });

        //지우개 버튼
        mClearBtn = (ImageButton) findViewById(R.id.eraser_img_btn);
        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.clear();
            }
        });


        paintView = (PaintView) findViewById(R.id.paintview);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        paintView.init(metrics);
    }
    public void change_to_red(View v) {
        paintView.set1_to_red();

    }

}
