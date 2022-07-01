package com.example.myapplication6;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {

    private Context mContext;
    private int[] data;

    public CustomAdapter(Context mContext, int[] data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView==null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(300,300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0,0,0,0);
        }else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(data[position]);

        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                View dialogView = View.inflate(mContext, R.layout.dialog,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(mContext);
                ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(data[position]);

                dlg.setTitle("hi");
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기",null);
                dlg.show();
            }
        });

        return imageView;
    }
}

