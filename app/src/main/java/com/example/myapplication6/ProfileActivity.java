package com.example.myapplication6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        String nameRecieved = intent.getStringExtra("name");
        String numberRecieved = intent.getStringExtra("number");
        int imageRecieved = intent.getIntExtra("image",0);

        TextView nameText = (TextView)findViewById(R.id.name);
        TextView numberText = (TextView)findViewById(R.id.number);
        ImageView imgv = (ImageView)findViewById(R.id.pimage);

        imgv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), PhotoViewScreen.class);
                intent.putExtra("image",imageRecieved);
                view.getContext().startActivity(intent);

            }
        });

        ImageView backbutton = (ImageView)findViewById(R.id.backbutton);

        backbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        imgv.setImageResource(imageRecieved);
        nameText.setText(nameRecieved);
        numberText.setText(numberRecieved);
    }

}
