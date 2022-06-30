package com.example.myapplication6;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;



public class Fragment2 extends Fragment {
    public static Fragment2 newInstance(int number) {
        Fragment2 fragment2 = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putInt("number", number);
        fragment2.setArguments(bundle);
        return fragment2;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            int num = getArguments().getInt("number");
        }
    }
    private int[] data = { R.drawable.emoji_1, R.drawable.emoji_2, R.drawable.emoji_3, R.drawable.emoji_4,
            R.drawable.emoji_5, R.drawable.emoji_6, R.drawable.emoji_7, R.drawable.emoji_8, R.drawable.emoji_9,
            R.drawable.emoji_1, R.drawable.emoji_2, R.drawable.emoji_3, R.drawable.emoji_4,
            R.drawable.emoji_5, R.drawable.emoji_6, R.drawable.emoji_7, R.drawable.emoji_8, R.drawable.emoji_9,
            R.drawable.emoji_1, R.drawable.emoji_2, R.drawable.emoji_3, R.drawable.emoji_4,
            R.drawable.emoji_5, R.drawable.emoji_6, R.drawable.emoji_7, R.drawable.emoji_8, R.drawable.emoji_9};

    private CustomAdapter adapter = null;
    private GridView gv = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(inflater.getContext()).inflate(R.layout.fragment2, container, false);
    }




}

