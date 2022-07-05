package com.example.myapplication6;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

public class PhotoViewScreen extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mRecyclerAdapter;
    private ArrayList<RecyclerData> mfriendItems;
    private SnapHelper msnapHelper;
    private SnapHelper tsnapHelper;
    private LinearLayoutManager mLayoutManager;
    private RecyclerDecoration spaceDecoration = new RecyclerDecoration(0);
    private LinearLayoutManager xLayoutManager;
    private LinearLayoutManager tLayoutManager;
    private TRecyclerAdapter tRecyclerAdapter;

    int currentPosition = RecyclerView.NO_POSITION;

    private RecyclerView tRecyclerView;










    public void GotoThere(int position, View v) {

        int centerOfScreen = mRecyclerView.getWidth() / 2 - v.getWidth()/2;
        xLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(xLayoutManager);
        xLayoutManager.scrollToPositionWithOffset(position,centerOfScreen);
    }

    public void HappyGo(int position) {
        int centerOfScreen = mRecyclerView.getWidth() / 2 -90;
        xLayoutManager.scrollToPositionWithOffset(position, centerOfScreen);
    }

    public void PleaseGo(int position) {
        tLayoutManager.scrollToPosition(position);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoviewscreen);

        Intent intent = getIntent();

        int imageRecieved1 = intent.getIntExtra("image",0);
        int[] listRecieved1 = intent.getIntArrayExtra("datalist");
        int posi = intent.getIntExtra("posi",0);





        ImageView backbutton = (ImageView)findViewById(R.id.backbutton);

        backbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.mainrecyclerview);
        mRecyclerView.addItemDecoration(spaceDecoration);
        mRecyclerAdapter = new MyRecyclerAdapter();

        mLayoutManager = new LinearLayoutManager(this);
        xLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false);

        tRecyclerView = (RecyclerView) findViewById(R.id.trecyclerview);
        tRecyclerAdapter = new TRecyclerAdapter();

        tLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false);

        tRecyclerView.setAdapter(tRecyclerAdapter);

        tRecyclerView.setLayoutManager(tLayoutManager);













        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(MyRecyclerAdapter.ViewHolder holder, View view, int position) {

                GotoThere(position, view);
                PleaseGo(position);
            }
        });













        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                    int firstVisibleItemPosition = xLayoutManager.findFirstVisibleItemPosition();
                    int lastVisibleItemPosition = xLayoutManager.findLastVisibleItemPosition();
                    if (firstVisibleItemPosition == -1) {
                        mRecyclerView.setLayoutManager(xLayoutManager);
                    }else{
                        if (lastVisibleItemPosition - firstVisibleItemPosition == 6) {
                            PleaseGo(firstVisibleItemPosition+3);
                        }
                        else if (lastVisibleItemPosition - firstVisibleItemPosition == 5){
                            PleaseGo(firstVisibleItemPosition+3);
                        }
                    }


                }

            }
        });
        tRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                    int firstVisibleItemPosition = tLayoutManager.findFirstVisibleItemPosition();
                    int lastVisibleItemPosition = tLayoutManager.findLastVisibleItemPosition();
                    if (firstVisibleItemPosition == -1) {
                        tRecyclerView.setLayoutManager(tLayoutManager);
                    }else{
                        HappyGo(firstVisibleItemPosition);
                    }



                }
            }
        });



        mfriendItems = new ArrayList<>();


        for(int i=0; i<=listRecieved1.length-1; i++){
            mfriendItems.add(new RecyclerData(listRecieved1[i],"",""));
        }

        mRecyclerAdapter.setFriendList(mfriendItems);

        msnapHelper = new LinearSnapHelper();
        msnapHelper.attachToRecyclerView(mRecyclerView);

        tsnapHelper = new LinearSnapHelper();

        tsnapHelper.attachToRecyclerView(tRecyclerView);

        tRecyclerAdapter.setFriendList(mfriendItems);


        PleaseGo(posi);
        HappyGo(posi);




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
