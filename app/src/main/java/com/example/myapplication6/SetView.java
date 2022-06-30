package com.example.myapplication6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class SetView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    private int x,y;

    public SetView(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);

        paint.setStrokeWidth(10);

        canvas.drawPath(path, paint);
    }

    public boolean onTouchEvent(MotionEvent event) {
       x = (int)event.getX();
       y = (int)event.getY();

       switch (event.getAction()) {
           case MotionEvent.ACTION_DOWN:
               path.moveTo(x,y);
               break;
           case MotionEvent.ACTION_MOVE:
               x = (int)event.getX();
               y = (int)event.getY();

               path.lineTo(x,y);
               break;
       }

       //onDraw 호출
       invalidate();

       return true;
    }
}
