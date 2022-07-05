package com.example.myapplication6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    ImageView imgv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        String nameRecieved = intent.getStringExtra("name");
        String numberRecieved = intent.getStringExtra("number");
        //Bitmap imageRecieved = (Bitmap) intent.getParcelableExtra("image");

        ImageView previewThumbnail = new ImageView(getApplicationContext());
        Bitmap imageRecieved = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("image"), 0, getIntent().getByteArrayExtra("image").length);
        previewThumbnail.setImageBitmap(imageRecieved);


        TextView nameText = (TextView)findViewById(R.id.name);
        TextView numberText = (TextView)findViewById(R.id.number);
        imgv = (ImageView)findViewById(R.id.pimage);

        imgv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(view.getContext(), PhotoViewScreen.class);

                Bitmap b; // your bitmap
                ByteArrayOutputStream bs1 = new ByteArrayOutputStream();
                imageRecieved.compress(Bitmap.CompressFormat.PNG, 50, bs1);

                intent.putExtra("image", imageRecieved);
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


        imgv.setImageBitmap(imageRecieved);
        nameText.setText(nameRecieved);
        numberText.setText(numberRecieved);
    }


    public void onButton_editClicked(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        intent.setAction(Intent.ACTION_PICK);
        activityResultLauncher.launch(intent);
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        Uri uri = intent.getData();
                        try {
                            Bitmap bm = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                            imgv.setImageBitmap(bm);
                        } catch (FileNotFoundException exception) {
                            exception.printStackTrace();
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
    );

}
