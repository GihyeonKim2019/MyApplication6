package com.example.myapplication6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

import java.io.FileOutputStream;

public class DrawActivity  extends AppCompatActivity {
    public PaintView paintView;
    private ImageButton mDoneBtn;
    private ImageButton mClearBtn;
    TextView colorTextView;
    View colorView;

    ImageView pic1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        //paintView = new PaintView(this);
       // colorTextView = findViewById(R.id.color_text_view);

        colorView = findViewById(R.id.color_view);

        pic1 = (ImageView)findViewById(R.id.pic1);

        ColorPickerView colorPickerView = findViewById(R.id.colorPickerView);
        colorPickerView.setColorListener(new ColorEnvelopeListener() {
            @Override
            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                //colorTextView.setText(envelope.getHexCode());
                colorView.setBackgroundColor(envelope.getColor());
                paintView.set1_color(envelope.getColor());
            }
        });

        //완성화면으로, 그림결과 넘겨주기
//        mDoneBtn = (ImageButton) findViewById(R.id.done_btn);
//        mDoneBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//
//                Bitmap b = Bitmap.createBitmap(paintView.getWidth(),paintView.getHeight(),Bitmap.Config.ARGB_8888);
//                Canvas c = new Canvas(b);
//                paintView.draw(c);
//                FileOutputStream fos = null;
//                try {
//                    fos = new FileOutputStream("view_image" + System.currentTimeMillis() + ".png");
//                    if (fos != null) {
//                        b.compress(Bitmap.CompressFormat.PNG, 100, fos);
//                        fos.close();
//                    }
//                }catch (Exception e) {
//                    Log.e("testView", "Exception : " + e.toString());
//                }
//            }
//
//        });


//        mDoneBtn = (ImageButton) findViewById(R.id.done_btn);
//        mDoneBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                paintView.saveBitmapToJpeg(paintView.getmBitmap() ,"picture1" );
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
    public void change_to_black(View v) {
        paintView.set1_to_black();

    }

    public void onButton_done_Clicked(View v) {
        Toast.makeText(this,"저장하기", Toast.LENGTH_LONG).show();
        paintView.saveBitmapToJpeg(paintView.getmBitmap() ,"picture1" );
        pic1.setImageBitmap(paintView.getBitmapFromCache("picture1"));
        MediaStore.Images.Media.insertImage(this.getContentResolver(), paintView.getmBitmap(), "hi","hello");
    }


}
